package com.mayurshingote.myphoneinfo;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView TextViewMacAddress = (TextView)findViewById(R.id.TextViewMacAddress);
        String MacAddressValue = GetMacAddressValue();
        TextViewMacAddress.setText(MacAddressValue);
    }

    public String GetMacAddressValue(){
        StringBuilder builder = new StringBuilder();
        try{
            WifiManager manager = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            WifiInfo info = manager.getConnectionInfo();
            String address = info.getMacAddress();
            builder.append("Mac Address: ");
            builder.append(address);
        }
        catch(Exception exception) {

        }
        return builder.toString();
    }
}
