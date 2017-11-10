
<template>
    <div>
        <p style="color:lightslategrey;">
            {{item.nickname}}
        </p>
        <p class="uk-card uk-card-small uk-card-default">
            {{ item.content }}
            <!--<img src="../../../img/X.png" class="delete" v-on:click="del"> -->
        </p>
    </div>
</template>

<script>
    export default {
        props: ["item"],
        data : function() {
            return {}
        },
        methods : {
            del:function(){

                this.$emit("removeSpeech",this.item);

            }
        }
    }
</script>

<style>

    .delete{
        margin-left:5px;
        width:10px;
        height:10px;

    }

</style>