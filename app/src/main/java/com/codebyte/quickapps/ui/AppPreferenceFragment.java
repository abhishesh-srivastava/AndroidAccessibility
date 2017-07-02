package com.codebyte.quickapps.ui;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.ListView;

import com.codebyte.quickapps.AsyncCallback;
import com.codebyte.quickapps.models.AppInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhishesh.s on 02/07/17.
 */

public class AppPreferenceFragment extends Fragment {

    private PackageManager mPm;
    private ListView mListView;
    private List<AppInfo> mList = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPm = getContext().getPackageManager();
        getAppList(new AsyncCallback() {
            @Override
            public void onSuccess() {
            }

            @Override
            public void onError(int errorCode, String errorReason) {

            }
        });
    }

    public void getAppList(final AsyncCallback callback) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
                mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);

                List<ResolveInfo> appList = mPm.queryIntentActivities(mainIntent, 0);
                for (ResolveInfo resolveInfo : appList) {
                    AppInfo appInfo = new AppInfo.Builder().addName(resolveInfo.loadLabel(mPm).toString())
                            .addDefaultActivity(resolveInfo.activityInfo.name)
                            .addIcon(resolveInfo.getIconResource())
                            .addPackageName(resolveInfo.activityInfo.packageName)
                            .build();
                    mList.add(appInfo);
                }
                if (callback != null) callback.onSuccess();
            }
        });
        thread.start();
    }
}
