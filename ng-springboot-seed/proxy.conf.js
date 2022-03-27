/**
 * For more configuration, please refer to https://angular.io/guide/build#proxying-to-a-backend-server
 *
 * 更多配置描述请参考 https://angular.cn/guide/build#proxying-to-a-backend-server
 *
 * Note: The proxy is only valid for real requests, Mock does not actually generate requests, so the priority of Mock will be higher than the proxy
 */

const PROXY_CONFIG = [{
  /** 认证服务代理 */
  context: '/auth',
  target: 'http://localhost:9000/',
  secure: false, // Ignore invalid SSL certificates
  changeOrigin: true,
  pathRewrite: { "^/auth": "" }
}, {
  context: '/kaoq',
  target: 'http://localhost:9001/',
  secure: false, // Ignore invalid SSL certificates
  changeOrigin: true,
  pathRewrite: { "^/kaoq": "" }
}];

module.exports = PROXY_CONFIG;
