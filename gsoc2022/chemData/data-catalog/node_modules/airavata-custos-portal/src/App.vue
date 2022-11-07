<template>
  <div id="app">
    <Header/>
    <div class="w-100" id="nav">
      <router-view/>
    </div>
    <Footer/>
  </div>
</template>

<script>
import Header from "./lib/components/block/Header";
import store from "./lib/store";
import Footer from "./lib/components/block/Footer";

export default {
  name: 'App',
  store: store,
  components: {Footer, Header},
  methods: {
    redirectToLoginIfNotAuthenticated() {
      if (!this.authenticated && this.$router.currentRoute.path !== "/") {
        this.$router.push('/')
      }
    }
  },
  watch: {
    authenticated() {
      this.redirectToLoginIfNotAuthenticated()
    }
  },
  computed: {
    authenticated: () => store.getters["auth/authenticated"],
    currentUsername: () => store.getters["auth/currentUsername"]
  },
  mounted() {
    this.redirectToLoginIfNotAuthenticated()
    // this.$store.dispatch("user/fetchUsers", {username: this.currentUsername});
  }
}
</script>

<style>
#app {
  /*font-family: Avenir, Helvetica, Arial, sans-serif;*/
  /*-webkit-font-smoothing: antialiased;*/
  /*-moz-osx-font-smoothing: grayscale;*/
  /*text-align: center;*/
  /*color: #2c3e50;*/
  /*margin-top: 60px;*/
}
</style>
