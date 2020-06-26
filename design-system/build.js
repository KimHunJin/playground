const webpack = require("webpack");
const config = require("./webpack.config");
const rimraf = require("rimraf");
const path = require("path");
const glob = require('glob');
const fs = require('fs');

webpack(config, async (err, stats) => {
    if (stats) {
        console.log(stats.toString());
    }
    if (err || stats.hasErrors()) {
        throw err;
    }

    rimraf.sync(path.resolve(__dirname, "./lib/src/stories"));
    rimraf.sync(path.resolve(__dirname, "./lib/src/components/styleImport.d.ts"));
    rimraf.sync(path.resolve(__dirname, "./lib/src/components/polyfills.d.ts"));

    glob(path.resolve(__dirname, './src/components/**/*.def.less'), function (err, files) {
        let res = '';
        if (files && files.length) {
            files.forEach(fileName => {
                let content = fs.readFileSync(fileName, "utf8");

                content = content.replace(/\/\/.*[\n\r]/gi, '');
                content = content.replace(/@import.*[\n\r]/gi, '');

                res += content + '\n';
            });
        }
        fs.writeFileSync(path.resolve(__dirname, './lib/style.less'), res);
    });
});
