<template>
  <div class="container">
    <div class="card">
      <div class="card-header">
        <h3>Add Item</h3>
      </div>
      <div class="card-body">
        <form v-on:submit.prevent="addItem">
          <div v-show="message" class="alert alert-danger">{{message}}</div>
          <div class="form-group">
            <label>Item Name:</label>
            <input type="text" class="form-control" v-model="item.name" />
          </div>
          <div class="form-group">
            <label>Item Price:</label>
            <input type="text" class="form-control" v-model="item.price" />
          </div>
          <div class="form-group">
            <input type="submit" class="btn btn-primary" value="Add Item" />
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      item: {},
      message: ""
    };
  },
  methods: {
    addItem() {
      let uri = "/items/";
      this.axios
        .post(uri, this.item)
        .then(() => {
          this.$swal({
            icon: "success",
            text: "Created Success!"
          });
          this.$router.push({ name: "Index" });
        })
        .catch(error => {
          this.message = `status: ${error.response.status}, message: ${error.response.data}`;
        });
    }
  }
};