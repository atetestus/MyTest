package com.lank.mytest;

import android.app.Instrumentation;
import android.content.Context;
import android.os.Bundle;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;

import static java.lang.System.out;

import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)

public class CtaCameraFormatTest {

    public UiDevice device;
    private Instrumentation instrumentation;
    public Bundle bundle;
    public Log L;
    String TAG = "Testlog";

    @Before
    public void before() {
        // Initialize UiDevice instance
        instrumentation = InstrumentationRegistry.getInstrumentation();
        device = UiDevice.getInstance(instrumentation);
        bundle = InstrumentationRegistry.getArguments();
        assertThat(device, notNullValue());
    }

    @After
    public void after() {
        //L.i(TAG + "After");
        out.println("hello world");
    }











}
