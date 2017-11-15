
import './style.css';
import 'uikit/dist/css/uikit.min.css'
import Vue from 'vue';
import App from './App.vue';
import Chat from './component/Chat/Chat.vue';
import Speech from './component/Chat/Speech.vue';
import Code from './component/Code/Code.vue';
import Navbar from './component/Nav/Navbar.vue';
import UIkit from 'uikit';
import Icons from 'uikit/dist/js/uikit-icons';
import VueRouter from 'vue-router';
import routes from './routes/routes';


// loads the Icon plugin
UIkit.use(Icons);

Vue.use(VueRouter);

Vue.component('Speech', Speech);
Vue.component('Chat',Chat);
Vue.component('Navbar',Navbar);
Vue.component('Code',Code);

Vue.prototype.UIkit = UIkit;

const router = new VueRouter({
    mode: 'history',
    scrollBehavior: () => ({ y: 0 }),
    routes
});


new Vue({
    router,
    render: h => h(App)

}).$mount("#app");