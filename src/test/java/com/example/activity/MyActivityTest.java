package com.example.activity;

import android.widget.TextView;

import com.example.R;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = "src/main/AndroidManifest.xml", emulateSdk = 18)
public class MyActivityTest {

    @Test
    public void testCreateActivity() throws Exception {
        assertTrue(Robolectric.buildActivity(MyActivity.class).create().get() != null);
    }

    @Test
    public void testNameApp() throws Exception {
        String appName = Robolectric.buildActivity(MyActivity.class).create().get()
                .getResources().getString(R.string.app_name);
        assertThat(appName, equalTo("TestingApp"));
    }

    @Test
    public void testExistsTest() throws Exception {
        MyActivity activity = Robolectric.buildActivity(MyActivity.class).create().get();
        TextView textView = (TextView) activity.findViewById(R.id.text);
        assertNotEquals(textView, null);
    }
}
