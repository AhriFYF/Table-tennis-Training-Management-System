<template>
  <div id="app">
    <MyIndex></MyIndex>
  </div>
</template>

<script>

import MyIndex from "@/components/MyIndex.vue";

export default {
  name: 'App',
  components: {
    MyIndex
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
