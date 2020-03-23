import Vue from 'vue'
import VueRouter from 'vue-router'
import Create from '../views/Create.vue'
import Edit from '../views/Edit.vue'
import Index from '../views/Index.vue'

Vue.use(VueRouter)

const routes = [
  {
    name: 'Index',
    path: '/',
    component: Index
  },
  {
    name: 'Create',
    path: '/create',
    component: Create
  },
  {
    name: 'Edit',
    path: '/edit',
    component: Edit
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
