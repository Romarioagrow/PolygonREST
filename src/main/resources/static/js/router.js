import Vue          from 'vue';
import VueRouter    from "vue-router";
import TestPage     from "pages/TestPage.vue";
import Catalog      from "pages/Catalog.vue";
import Products     from "pages/Products.vue";
import ProductInfo  from "pages/ProductInfo.vue";
import Admin        from "pages/Admin.vue";
import Login        from "pages/Login.vue";
import UserCabinet  from "pages/UserCabinet.vue";
import Order        from "pages/Order.vue";

Vue.use(VueRouter);
const routes = [
    {path: '/', component: Catalog},
    {path: '/catalog/:category', component: Catalog},
    {path: '/products/:group', component: Products},
    {path: '/order', component: Order},
    {path: '/products/product/:productID', component: ProductInfo},
    {path: '/admin', component: Admin},
    {path: '/login', component: Login},
    {path: '/user/cabinet', component: UserCabinet},
    {path: '/test', component: TestPage},
];

export default new VueRouter({
    mode: 'history',
    routes
})