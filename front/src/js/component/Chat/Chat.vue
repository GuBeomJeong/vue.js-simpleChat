

<template>
    <div>
        <div class="uk-text-center">
            채팅
        </div>
        <div class="uk-card uk-card-default uk-card-body" id ="chat">
            <div uk-spinner v-show="spinnerActive === true"></div>
            <div v-for="item in items" v-show="spinnerActive === false">
                <Speech :item="item" v-on:removeSpeech="deleteSpeech"></Speech>
            </div>
        </div>

        <div uk-grid>
            <div class=" uk-width-3-4">
                <input class="uk-input" v-model="content" v-on:keyup.enter="submitData" placeholder="">
            </div>
            <div class=" uk-width-1-4">
                <span class="uk-badge" id="submit" v-on:click="submitData">입력</span>
            </div>
        </div>

        <div uk-grid>
            <div class=" uk-width-1-4">
                Nickname
            </div>
            <div class=" uk-width-3-4">
                <input class="uk-input" v-model="nickname" >
            </div>
        </div>

        <div>
            <p>
                현재 {{ connection_num }}명 접속중
            </p>
        </div>

    </div>
</template>

<script>
    import axios from "axios";
    import property from "../../property/property.json"


    export default {
        data: function() {
            return {
                content:"",
                nickname:"Jeong",
                connection_num:0,
                items:[

                ],
                spinnerActive:true
            }
        },
        created:function(){

            this.ws = new WebSocket(property.socket_address);
            this.ws.onopen = function () {
                console.log("socket open");
            };
            this.ws.onmessage = function (message) {
                console.log(message.data);
                let msg = JSON.parse(message.data);

                if(msg.type === "num"){
                    this.connection_num = msg.connection_num;
                }else{

                    this.addMessage(msg);
                }

            }.bind(this);
            this.ws.onclose = function (event) {
                console.log("socket closed");
            };

            this.getData();
        },
        mounted:function(){
            this.chatEl = document.getElementById("chat");
        },
        destroyed:function(){
           this.ws.close();
        },
        updated:function(){
            this.fixScroll();

        },
        methods:{
            submitData(e){
                let message = {
                    nickname : this.nickname,
                    content : this.content
                };
                this.ws.send(JSON.stringify(message));
                this.content = "";
            },
            deleteSpeech(item){
                this.items.splice(this.items.indexOf(item),1);
            },
            getData(){
                axios.get("/api/chat").then(
                    (result)=>{
                        this.items =  result.data;
                        this.spinnerActive = false;
                    }
                );
            },
            addMessage(msg){

                this.items.push({
                    content:msg.content,
                    date:msg.date,
                    nickname:msg.nickname
                });
            },
            fixScroll(){
                this.chatEl.scrollTop = this.chatEl.scrollHeight;
            }

        }
    }
</script>

<style>
#submit {
    cursor:pointer;
}

#chat {
    height : 500px;
    overflow-y: scroll;
}


</style>