<template>
  <div>
    <h1>Items</h1>

    <table class="table table-hover">
      <thead>
        <tr>
          <td>ID</td>
          <td>Item Name</td>
          <td>Item Price</td>
          <td>Actions</td>
        </tr>
      </thead>

      <tbody>
        <tr v-for="item in items" :key="item._id">
          <td>{{ item.id }}</td>
          <td>{{ item.name }}</td>
          <td>{{ item.price }}</td>
          <td>
            <router-link :to="{name: 'Edit', params: { id: item.id }}" class="btn btn-primary">Edit</router-link>
          </td>
          <td>
            <button class="btn btn-danger" v-on:click="deleteItem(item.id)">Delete</button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      items: []
    };
  },
  created: function() {
    this.fetchItems();
  },
  methods: {
    fetchItems() {
      let uri = "/items";
      this.axios.get(uri).then(response => {
        this.items = response.data;
      });
    },
    deleteItem(id) {
      let uri = "/items/" + id;
      this.axios.delete(uri).then(() => {
        this.fetchItems();
      });
    }
  }
};
</script>