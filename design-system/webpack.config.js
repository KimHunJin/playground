const webpack = require('webpack');
const {CleanWebpackPlugin} = require('clean-webpack-plugin');
const path = require('path');
const info = require('./package');

module.exports = {
    mode: 'production',
    entry: path.resolve(__dirname, './src/main.ts'),
    output: {
        path: path.resolve(__dirname, './lib/'),
        filename: 'main.js',
        library: info.name,
        libraryTarget: "umd",
        globalObject: 'this'
    },
    plugins: [
        new webpack.ProgressPlugin(),
        new CleanWebpackPlugin()
    ],
    module: {
        rules: [
            {
                test: /\.(ts|tsx)$/,
                use: [{
                    loader: 'ts-loader'
                }],
                exclude: [/node_modules/]
            },
            {
                test: /\.(less)$/,
                use: [
                    {loader: 'style-loader'},
                    {
                        loader: 'css-loader',
                        options: {
                            modules: {
                                mode: "local",
                                localIdentName: '[name]__[local]--[hash:base64:5]'
                            },
                            sourceMap: true
                        }
                    },
                    {loader: 'less-loader', options: {sourceMap: true}}
                ]
            },
            {
                test: /\.(ico|png|jpg|jpeg|gif|svg|woff|woff2|ttf|eot)(\?v=[0-9]\.[0-9]\.[0-9])?$/i,
                loader: 'url-loader',
                options: {
                    name: '[name].[ext]?[hash]'
                }
            }]
    },
    externals: {
        "react": "react",
        "react-dom": "react-dom",
    },
    resolve: {
        alias: {
            '@component': path.resolve(__dirname, './src/components')
        },
        extensions: ['.ts', '.tsx', '.js', '.jsx']
    }
};
