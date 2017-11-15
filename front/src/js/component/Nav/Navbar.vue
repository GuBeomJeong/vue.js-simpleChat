<template>
    <div uk-navbar>
        <div class="uk-navbar-right">
            <ul class="uk-navbar-nav">
                <li>
                    <a class="uk-navbar-toggle" uk-navbar-toggle-icon href=""></a>
                    <div class="uk-navbar-dropdown">
                        <ul class="uk-nav uk-navbar-dropdown-nav">
                            <li class="uk-active">Service</li>
                            <li class="uk-nav-divider"></li>
                            <li><router-link v-bind:to="{ name: 'Code' }">With Code</router-link></li>
                        </ul>
                    </div>
                </li>
            </ul>

        </div>
    </div>
</template>

<script>

</script>