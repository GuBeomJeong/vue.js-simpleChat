<template>
    <div class="uk-container">
        <pre>

            <code id="c" v-html="code">
            </code>
        </pre>
        <textarea class="uk-width-large uk-height-medium" v-model="str"> </textarea>

    </div>

</template>

<script>
    import Prism from "prismjs";
    import 'prismjs/themes/prism.css';

    export default {
        data: function () {
            return {
                code: "",
                str:""
            }
        },
        created: function () {

        },
        updated: function () {
            var html = Prism.highlight(this.str, Prism.languages.javascript);
            this.code = html;
        },
        mounted: function () {



        }
    }
</script>