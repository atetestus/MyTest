package com.lank.mytest;

import android.app.UiAutomation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void runCtsCameraCameraFormats(View v){
        new UiAutomatorThread().start();
    }

    class UiAutomatorThread extends Thread{
        @Override
        public void run(){
            super.run();
            String command = generateCommand("com.lank.mytest","CtaCameraFormatTest");
            try {
                Process p = Runtime.getRuntime().exec(command);
            }
            catch(Exception e){
                e.printStackTrace();
            }

        }
//m instrument -w -r   -e debug false -e class 'com.lank.mytest.CtaCameraFormatTest' com.lank.mytest.test/android.support.test.runner.AndroidJUnitRunner
        public String generateCommand(String pkgName,String clsName){
            String command = "am instrument --user 0 -w -r   -e debug false -e class "+pkgName+"."+clsName+" "+pkgName+".test/android.support.test.runner.AndroidJUnitRunner";
            return command;
        }

    }

}
