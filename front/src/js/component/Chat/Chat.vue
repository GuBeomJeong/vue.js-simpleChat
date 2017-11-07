

<template>
    <div>

        <div v-for="item in items">
            <Speech :item="item" v-on:removeSpeech="deleteSpeech"></Speech>
        </div>

        <input v-model="message" v-on:keyup.enter="make" placeholder="">
        <button v-on:click="make">입력</button>
        <button v-on:click="getData">갱신</button>
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
        methods:{
            make:function(e){
                this.items.push({
                    data:this.message
                });

                this.pushData();


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