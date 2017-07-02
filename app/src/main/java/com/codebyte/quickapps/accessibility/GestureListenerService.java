package com.codebyte.quickapps.accessibility;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat;
import android.util.Log;
import android.util.SparseArray;
import android.view.accessibility.AccessibilityEvent;

import com.codebyte.quickapps.AppController;
import com.codebyte.quickapps.models.AppInfo;
import com.codebyte.quickapps.util.GlobalConstants;

/**
 * Created by abhishesh.s on 02/07/17.
 */

public class GestureListenerService extends AccessibilityService {
    private SparseArray<AppInfo> mPackageArray = new SparseArray<>(GlobalConstants.TOTAL_NUMBER_OF_AVAILABLE_GESTURES);

    public AppInfo getLaunchPackage(int gestureId) {
        return mPackageArray.get(gestureId);
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {

    }

    @Override
    public void onInterrupt() {

    }

    @Override
    protected boolean onGesture(int gestureId) {
        AppInfo appInfo = getLaunchPackage(gestureId);
        if (appInfo != null) {
            Context context = getApplicationContext();
            ComponentName componentName = new ComponentName(appInfo.getPackageName(), appInfo.getDefaultActivity());
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setComponent(componentName);
            context.startActivity(intent);
            return true; //
        }
        return super.onGesture(gestureId);
    }

}
