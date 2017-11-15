

<template>
    <div>
        <div uk-grid>
            <div class="uk-width-4-5">
                <router-view id="contents"></router-view>
            </div>
            <Chat class ="uk-width-1-5" id="chat-container"></Chat>
        </div>
        <Navbar id="navbar"></Navbar>
    </div>
</template>

<script>
    export default {
        name: 'app',
        data: function() {
            return {

            }
        }
    }
</script>

<style>
    #contents{
        margin-left:100px;
    }
    #navbar{
        position: fixed;
        left:50px;
        top:10px;
    }

</style>