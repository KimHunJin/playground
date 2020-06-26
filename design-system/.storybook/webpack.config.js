const path = require('path');

module.exports = async ({config, mode}) => {
    config.module.rules.push(
        {
            test: /\.stories\.tsx$/,
            loaders: [
                {
                    loader: require.resolve('@storybook/addon-storysource/loader'),
                    options: {
                        parser: 'typescript',
                        prettierConfig: {
                            printWidth: 100,
                            singleQuote: false,
                        },
                    },
                },
            ],

            enforce: 'pre',
        },
        {
            test: /\.(ts|tsx)$/,
            use: [
                {
                    loader: require.resolve('ts-loader')
                }
            ],
        },
        {
            test: /\.less$/,
            use: [
                {loader: 'style-loader'},
                {
                    loader: 'css-loader',
                    options: {
                        sourceMap: true,
                        modules: {
                            mode: "local",
                            localIdentName: '[name]__[local]--[hash:base64:5]'
                        }
                    }
                },
                {loader: 'less-loader', options: {sourceMap: true}}
            ]
        }
    );

    config.resolve.alias['@component'] = path.resolve(__dirname, '../src/components');
    config.resolve.extensions.push('.ts', '.tsx', '.js', '.jsx');

    return config;
};
