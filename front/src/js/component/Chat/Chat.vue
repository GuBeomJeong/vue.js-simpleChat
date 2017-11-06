

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
                    value:this.message
                });

                this.message = "";
            },
            deleteSpeech(item){
                this.items.splice(this.items.indexOf(item),1);
            }
        }
    }
</script>

<style>

</style>