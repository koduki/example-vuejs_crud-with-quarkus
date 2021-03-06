module.exports = {
    devServer: {
        proxy: {
            "^/items": {
                target: "http://172.19.27.127:3000",
                ws: false,
                pathRewrite: {
                    "^/items": "/items"
                }
            }
        }
    },
    pages: {
        index: {
            entry: 'src/main.js', // 必須パラメータ
            title: 'ページタイトル',
        }
    }
};