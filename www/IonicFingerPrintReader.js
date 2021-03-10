var exec = require('cordova/exec');

// exports.coolMethod = function (arg0, success, error) {
//     exec(success, error, 'IonicFingerPrintReader', 'coolMethod', [arg0]);
// };

exports.getReader = function (success, error) {

    exec(success, error, 'FingerPrintReader', 'getReader');
};