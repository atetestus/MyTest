package com.lank.mytest;

import android.app.Instrumentation;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiDevice;

import static java.lang.System.out;

import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static java.lang.Thread.sleep;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)

public class CtaCameraFormatTest {

    public UiDevice device;
    private Instrumentation instrumentation;
    public Bundle bundle;
    public Log L;
    String TAG = "Testlog";
    public String lens ="";
    public String beforResolution = "";
    public String currentResolution = "";

    @Before
    public void before() {
        // Initialize UiDevice instance
        instrumentation = InstrumentationRegistry.getInstrumentation();
        device = UiDevice.getInstance(instrumentation);
        bundle = InstrumentationRegistry.getArguments();
        assertThat(device, notNullValue());
    }

    @Test
    public void testCtsCamera() throws UiObjectNotFoundException, InterruptedException {
        device.pressHome();
        sleep(2000);
        device.swipe(550,1400,550,400,5);
        sleep(3000);
        UiObject2 ctsApp = device.findObject(By.text("CTS Verifier"));
        ctsApp.click();
        device.waitForWindowUpdate("",3000);
        Log.i(TAG, "testCtsCamera: Launch CTS Verifier");
        try {
            while (device.hasObject(By.text("ALLOW"))) {
                UiObject2 press = device.findObject(By.text("ALLOW"));
                press.click();
                device.waitForWindowUpdate("", 3000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //測試Camera Formats
        UiScrollable camera = new UiScrollable(new UiSelector().scrollable(true));
        UiObject cameraFormats = camera.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()),"Camera Formats");
        cameraFormats.click();
        device.waitForWindowUpdate("", 3000);
        sleep(3000);
        try {
            while (device.hasObject(By.text("OK"))) {
                UiObject2 press = device.findObject(By.text("OK"));
                press.click();
                device.waitForWindowUpdate("", 3000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //UiObject2 camera0 = device.findObject(By.text("Camera 0"));
        //UiObject2 camera1 = device.findObject(By.text("Camera 1"));

        //開始測試Camera0
        //176x144
        lens = "Camera 0";
        beforResolution = "null";
        currentResolution = "176 x 144";
        modeTest(lens,beforResolution,currentResolution);

    }

    public void modeTest(String lens,String beforResolution,String currentResolution) throws UiObjectNotFoundException {
        this.lens = lens;
        this.beforResolution = beforResolution;
        this.currentResolution = currentResolution;

        UiObject2 camera = device.findObject(By.text(lens));
        camera.click();
        sleep(3000);
        camera.click();
        sleep(3000);
        if (beforResolution.equals("null")) {
            out.println("176x144 resolution");
        }
        else {
            UiObject2 Resolution1 = device.findObject(By.text(beforResolution));
            Resolution1.click();
        }
        sleep(3000);
        UiScrollable mode = new UiScrollable(new UiSelector().scrollable(true));
        UiObject Resolution2 = mode.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()),currentResolution);
        Resolution2.click();
        sleep(3000);
        UiObject2 NV21Mode = device.findObject(By.text("NV21"));
        NV21Mode.click();
        sleep(3000);
        UiObject2 YV12Mode = device.findObject(By.text("YV12"));
        YV12Mode.click();
        sleep(3000);
        YV12Mode.click();
        sleep(3000);
        NV21Mode.click();
        sleep(3000);
    }


    public void sleep(int mint){
        try {
            Thread.sleep(mint);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
