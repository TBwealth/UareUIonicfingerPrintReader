var exec = require('cordova/exec');
exports.getReader = function (args,success, error) {
    exec(success, error, 'FingerPrintReader', 'getReader', [args]);
};