
import './style.css';
import Vue from 'vue';
import App from './app.vue';
import Chat from './component/Chat/Chat.vue';
import Speech from './component/Chat/Speech.vue';

Vue.component('Speech', Speech);
Vue.component('Chat',Chat);

new Vue({
    el: '#app',
    render: h => h(App)
});