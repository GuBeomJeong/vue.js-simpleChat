
<template>
    <div class="speech"><p class="arrow_box">{{ item.value }}<img src="../../../img/X.png" class="delete" v-on:click="del"></p></div>
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
    .speech{
        width:200px;
    }
    .arrow_box {
        position: relative;
        background: #88b7d5;
        border: 2px solid #c2e1f5;
    }
    .arrow_box:after, .arrow_box:before {
        right: 100%;
        top: 50%;
        border: solid transparent;
        content: " ";
        height: 0;
        width: 0;
        position: absolute;
        pointer-events: none;
    }

    .arrow_box:after {
        border-color: rgba(136, 183, 213, 0);
        border-right-color: #88b7d5;
        border-width: 5px;
        margin-top: -5px;
    }
    .arrow_box:before {
        border-color: rgba(194, 225, 245, 0);
        border-right-color: #c2e1f5;
        border-width: 8px;
        margin-top: -8px;
    }

    .delete{
        margin-left:5px;
        width:10px;
        height:10px;

    }

</style>