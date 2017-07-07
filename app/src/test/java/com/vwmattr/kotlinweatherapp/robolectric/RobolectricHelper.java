package com.vwmattr.kotlinweatherapp.robolectric;


import android.app.Activity;

import org.robolectric.android.controller.ActivityController;
import org.robolectric.android.controller.ComponentController;

import java.lang.reflect.Field;

import static org.mockito.Mockito.spy;

/**
 * Helper methods for doing stuff in Robolectric.
 */
public class RobolectricHelper {

    private RobolectricHelper() { }

    /**
     * Pull the built activity out of the controller, spy it and push it back into the controller. Returns the spied
     * activity so you can mock and verify. The controller is modified in place, so you can continue using it after
     * this method returns to create the activity.
     * @param controller -
     * @param <T> -
     * @return -
     * @throws NoSuchFieldException -
     * @throws IllegalAccessException -
     */
    public static <T extends Activity> T injectSpiedActivityBeforeOnCreate(ActivityController<T> controller)
            throws NoSuchFieldException, IllegalAccessException {
        T testActivity = spy(controller.get());
        Field componentField = ComponentController.class.getDeclaredField("component");
        componentField.setAccessible(true);
        componentField.set(controller, testActivity);

        return testActivity;
    }
}