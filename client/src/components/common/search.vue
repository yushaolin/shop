<template>
    <div class="search-warp">
        <i-input search enter-button placeholder="Enter something..." v-value="serach_value"/>
    </div>
</template>
<script>
    export default{
        name: 'search',
        data() {
            return {
                serach_value: ''
            }
        }
    }
</script>
<style lang="scss" scoped>
.search-warp{
    width: 1226px;
    margin: 20px 0;
    margin-left: auto;
    margin-right: auto;
    text-align: right;
}
</style>

