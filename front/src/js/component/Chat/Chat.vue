

<template>
    <div>

        <div v-for="item in items">
            <Speech :item="item" v-on:removeSpeech="deleteSpeech"></Speech>
        </div>

        <input v-model="message" v-on:keyup.enter="make" placeholder="">
        <button v-on:click="make">입력</button>
    </div>

</template>

<script>
    import axios from "axios";

    export default {
        data: function() {
            return {
                message:"",
                items:[

                ]
            }
        },
        created:function(){
            this.ws = new WebSocket("ws://165.246.223.108:8080/chat");
            this.ws.onopen = function () {
                console.log('websocket opened');
            };
            this.ws.onmessage = function (message) {
                console.log(message);
                console.log('receive message : ' + message.data);
                this.items.push({
                    data:message.data
                });

            }.bind(this);
            this.ws.onclose = function (event) {
                console.log(event);
                console.log('websocket closed');
            };

            this.getData();
        },
        destroyed:function(){
           this.ws.close();
        },
        methods:{
            make:function(e){
//                this.items.push({
//                    data:this.message
//                });
                this.ws.send(this.message);
                this.message = "";
                //this.pushData();

            },
            deleteSpeech(item){
                this.items.splice(this.items.indexOf(item),1);
            },
            getData(){
                axios.get("/api/chat").then(
                    (result)=>{
                        this.items =  result.data;
                    }
                );
            },
            pushData(){
                console.log(this.message);
                axios.post("/api/chat",{"data":this.message}).then(()=>{this.message = "";});
            }
        }
    }
</script>

<style>

</style>