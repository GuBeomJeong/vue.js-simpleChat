

<template>
    <div>
        <ul>
            <li v-for="item in items">
                <test :message="item.what"></test>
            </li>
        </ul>
        <button v-on:click="make">Push</button>
    </div>

</template>

<script>
    export default {
        name: 'app',
        data: function() {
            return {
                index:2,
                items:[
                    {what:1},
                    {what:2}
                ]
            }
        },
        methods:{
            make:function(e){
                this.items.push({
                    what: this.index
                });

                this.index++;
            }
        }
    }
</script>

<style>

</style>