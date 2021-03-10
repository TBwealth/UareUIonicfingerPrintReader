var exec = require('cordova/exec');

// exports.coolMethod = function (arg0, success, error) {
//     exec(success, error, 'IonicFingerPrintReader', 'coolMethod', [arg0]);
// };

exports.getReader = function (args,success, error) {
//var args = {}
    exec(success, error, 'FingerPrintReader', 'getReader', [args]);
};