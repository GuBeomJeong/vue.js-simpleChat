module.exports = {
    entry: {
        "index" : './index.js'
    },

    output: {
        path: __dirname + '/bundle/',
        filename: '[name].bundle.js'
    },
    resolve: {
        alias: {
            'vue$': 'vue/dist/vue.esm.js'
        }
    },
    module: {
        rules: [
            {
                test: /\.css$/,
                use: [
                    'style-loader',
                    'css-loader'
                ]
            },
            {
                test: /\.js$/,
                exclude: /node_modules/,
                loader: 'babel-loader',
                options: {
                    presets: ['env',"stage-2"]
                }
            },
            {
                test: /\.vue$/,
                loader: 'vue-loader'
            },{
                test: /\.png$/,
                loader: 'file-loader', // 파일 읽어주는 로더
                options: {
                    publicPath: 'resources/src/js/bundle/',
                    name: '[name].[ext]?[hash]'
                    //name: '[name].[ext]'
                }
            },
            // {
            //     test: /\.png$/,
            //     use: {
            //         loader: 'url-loader', // 데이터가 작으면 그냥 문자열 형태로 변환하여 번들 파일에 넣어버림(http통신을 줄인다)
            //         options: {
            //             name: '[name].[ext]?[hash]',
            //             publicPath: '../js/bundle/',
            //             limit: 10000 // 10kb
            //         }
            //     }
            // }

        ]
    }
};

