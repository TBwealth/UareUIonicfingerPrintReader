package com.ionicfinger.ionicfingerprintreader;

import com.digitalpersona.uareu.ReaderCollection;
import com.digitalpersona.uareu.UareUException;
import com.digitalpersona.uareu.UareUGlobal;

import android.content.Context;
import android.app.Activity;
import android.widget.Toast; 

import org.apache.cordova.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class IonicFingerPrintReader extends CordovaPlugin {
    private ReaderCollection readers;
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException  {
        if (action.equals("getReader")) {
            this.getReader(callbackContext);
            return true;
        }

        return false;
    }
    private void getReader(CallbackContext callbackContext) throws JSONException {
        // initiliaze dp sdk
        int nSize = readers.size();
        JSONArray values = new JSONArray();
        JSONObject deviceObject = new JSONObject();
        Toast.makeText(
            webView.getContext(), 
            "Hello World Cordova Plugin",
            Toast.LENGTH_SHORT)
            .show(); 
        try
        {
            Context applContext = this.cordova.getActivity().getApplicationContext();
            readers = UareUGlobal.GetReaderCollection(applContext);
            readers.GetReaders();         
  
        if (nSize > 1)
        {
            //String[] values = null;
           // values = new String[nSize];
            for (int nCount = 0; nCount < nSize; nCount++)
            {
                values.put(readers.get(nCount).GetDescription().name);
                //values[nCount] = readers.get(nCount).GetDescription().name;
            }
            callbackContext.success(deviceObject.put("Devices",values));
        
        }
        else
        { 
           // String[] values = null;  
           // values = new String[1];   
            //values[0] = readers.get(0).GetDescription().name;  
            values.put(readers.get(0).GetDescription().name);
            callbackContext.success(deviceObject.put("Devices",values));
        }
        } catch (UareUException e) {
            callbackContext.error("Oops! Something went wrong");
        }
    
        
        }

}
