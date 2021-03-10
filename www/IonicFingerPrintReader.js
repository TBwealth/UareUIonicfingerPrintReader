// window.plugins.IonicFingerPrintReader

function IonicFingerPrintReader() {
}
IonicFingerPrintReader.prototype.getReader = function (args,success, error) {
    exec(success, error, 'FingerPrintReader', 'getReader', [args]);
};

// var exec = require('cordova/exec');
// exports.getReader = function (args,success, error) {
//     exec(success, error, 'FingerPrintReader', 'getReader', [args]);
// };