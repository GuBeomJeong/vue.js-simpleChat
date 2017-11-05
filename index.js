
import './style.css';
import Vue from 'vue';
import App from './app.vue';
import test from './component/test.vue';

Vue.component('test', test);


new Vue({
    el: '#app',
    render: h => h(App)
});