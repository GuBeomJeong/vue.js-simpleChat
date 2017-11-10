
import './style.css';
import 'uikit/dist/css/uikit.min.css'
import Vue from 'vue';
import App from './app.vue';
import Chat from './component/Chat/Chat.vue';
import Speech from './component/Chat/Speech.vue';
import UIkit from 'uikit';
import Icons from 'uikit/dist/js/uikit-icons';

// loads the Icon plugin
UIkit.use(Icons);

Vue.component('Speech', Speech);
Vue.component('Chat',Chat);
Vue.prototype.UIkit = UIkit;

new Vue({
    el: '#app',
    render: h => h(App)
});