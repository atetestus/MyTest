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


//m instrument -w -r   -e debug false -e class 'com.lank.mytest.CtaCameraFormatTest' com.lank.mytest.test/android.support.test.runner.AndroidJUnitRunner

@RunWith(AndroidJUnit4.class)

public class CtaCameraFormatTest {

    public UiDevice device;
    private Instrumentation instrumentation;
    public Bundle bundle;
    public Log L;
    String TAG = "Testlog";
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

        //開始測試Camera 0
        UiObject2 len0 = device.findObject(By.text("Camera 0"));
        len0.click();
        sleep(2000);
        UiObject2 camera0 = device.findObject(By.text("Camera 0"));
        camera0.click();
        sleep(3000);

        //176x144
        beforResolution = "176 x 144";
        currentResolution = "176 x 144";
        modeTest(beforResolution,currentResolution);

        //320x240
        beforResolution = "176 x 144";
        currentResolution = "320 x 240";
        modeTest(beforResolution,currentResolution);

        //640x480
        beforResolution = "320 x 240";
        currentResolution = "640 x 480";
        modeTest(beforResolution,currentResolution);

        //960x960
        beforResolution = "640 x 480";
        currentResolution = "960 x 960";
        modeTest(beforResolution,currentResolution);

        //1080x1080
        beforResolution = "960 x 960";
        currentResolution = "1080 x 1080";
        modeTest(beforResolution,currentResolution);

        //1280x640
        beforResolution = "1080 x 1080";
        currentResolution = "1280 x 640";
        modeTest(beforResolution,currentResolution);

        //1280x720
        beforResolution = "1280 x 640";
        currentResolution = "1280 x 720";
        modeTest(beforResolution,currentResolution);

        //1280x960
        beforResolution = "1280 x 720";
        currentResolution = "1280 x 960";
        modeTest(beforResolution,currentResolution);

        //1680x1680
        beforResolution = "1280 x 960";
        currentResolution = "1680 x 1680";
        modeTest(beforResolution,currentResolution);

        //1920x960
        beforResolution = "1680 x 1680";
        currentResolution = "1920 x 960";
        modeTest(beforResolution,currentResolution);

        //1920x1080
        beforResolution = "1920 x 960";
        currentResolution = "1920 x 1080";
        modeTest(beforResolution,currentResolution);

        //1920x1440
        beforResolution = "1920 x 1080";
        currentResolution = "1920 x 1440";
        modeTest(beforResolution,currentResolution);

        //開始測試Camera 1
        UiObject2 len1 = device.findObject(By.text("Camera 0"));
        len1.click();
        sleep(2000);
        UiObject2 camera1 = device.findObject(By.text("Camera 1"));
        camera1.click();
        sleep(3000);

        //176x144
        beforResolution = "176 x 144";
        currentResolution = "176 x 144";
        modeTest(beforResolution,currentResolution);

        //320x240
        beforResolution = "176 x 144";
        currentResolution = "320 x 240";
        modeTest(beforResolution,currentResolution);

        //640x480
        beforResolution = "320 x 240";
        currentResolution = "640 x 480";
        modeTest(beforResolution,currentResolution);

        //960x960
        beforResolution = "640 x 480";
        currentResolution = "960 x 960";
        modeTest(beforResolution,currentResolution);

        //1080x1080
        beforResolution = "960 x 960";
        currentResolution = "1080 x 1080";
        modeTest(beforResolution,currentResolution);

        //1280x640
        beforResolution = "1080 x 1080";
        currentResolution = "1280 x 640";
        modeTest(beforResolution,currentResolution);

        //1280x720
        beforResolution = "1280 x 640";
        currentResolution = "1280 x 720";
        modeTest(beforResolution,currentResolution);

        //1280x960
        beforResolution = "1280 x 720";
        currentResolution = "1280 x 960";
        modeTest(beforResolution,currentResolution);

        //1680x1680
        beforResolution = "1280 x 960";
        currentResolution = "1680 x 1680";
        modeTest(beforResolution,currentResolution);

        //1920x960
        beforResolution = "1680 x 1680";
        currentResolution = "1920 x 960";
        modeTest(beforResolution,currentResolution);

        //1920x1080
        beforResolution = "1920 x 960";
        currentResolution = "1920 x 1080";
        modeTest(beforResolution,currentResolution);

        //1920x1440
        beforResolution = "1920 x 1080";
        currentResolution = "1920 x 1440";
        modeTest(beforResolution,currentResolution);

        //TestFinish
        UiObject2 pass = device.findObject(By.res("com.android.cts.verifier:id/pass_button"));
        pass.click();
        sleep(2000);

        device.pressBack();
        device.pressBack();
        device.pressBack();

    }

    public void modeTest(String beforResolution,String currentResolution) throws UiObjectNotFoundException {

        this.beforResolution = beforResolution;
        this.currentResolution = currentResolution;

        UiObject2 Resolution1 = device.findObject(By.text(beforResolution));
        Resolution1.click();
        sleep(2000);
        UiScrollable modeSelect = new UiScrollable(new UiSelector().scrollable(true));
        UiObject Resolution2 = modeSelect.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()),currentResolution);
        Resolution2.click();
        sleep(2000);
        UiObject2 NV21Mode1 = device.findObject(By.text("NV21"));
        NV21Mode1.click();
        sleep(2000);
        UiObject2 YV12Mode1 = device.findObject(By.text("YV12"));
        YV12Mode1.click();
        sleep(3000);
        UiObject2 YV12Mode2 = device.findObject(By.text("YV12"));
        YV12Mode2.click();
        sleep(2000);
        UiObject2 NV21Mode2 = device.findObject(By.text("NV21"));
        NV21Mode2.click();
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
