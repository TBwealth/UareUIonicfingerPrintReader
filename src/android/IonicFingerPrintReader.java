package com.ionicfinger.ionicfingerprintreader;

import com.digitalpersona.uareu.ReaderCollection;
import com.digitalpersona.uareu.UareUException;
import com.digitalpersona.uareu.UareUGlobal;

import android.content.Context;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class IonicFingerPrintReader extends CordovaPlugin {
    private ReaderCollection readers;
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("getReader")) {
            this.getReader(callbackContext);
            return true;
        }

        return false;
    }
    private void getReader(CallbackContext callback) {
        // initiliaze dp sdk
        try
        {
            Context applContext = getApplicationContext();
            readers = UareUGlobal.GetReaderCollection(applContext);
            readers.GetReaders();
    
            
        int nSize = readers.size();
        if (nSize > 1)
        {
            String[] values = null;
            values = new String[nSize];
            for (int nCount = 0; nCount < nSize; nCount++)
            {
                values[nCount] = readers.get(nCount).GetDescription().name;
            }
            callback.success(values);
        
        }
        else
        { 
            String[] values = null;  
            values = new String[1];   
            values[0] = readers.get(nCount).GetDescription().name;  
            callback.success(values);
        }
        } catch (UareUException e) {
            callback.error("Oops! Something went wrong");
        }
    
        
        }

}
