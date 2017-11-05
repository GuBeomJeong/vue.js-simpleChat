
<template>
    <div class="example">{{ message }}</div>
</template>

<script>
    export default {
        props: ["message"],
        data : function() {
            return {}
        }
    }
</script>

<style>
    .example {
        color: blue;
    }
</style>