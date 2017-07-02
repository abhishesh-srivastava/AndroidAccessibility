package com.codebyte.quickapps.db;

import android.provider.BaseColumns;

/**
 * Created by abhishesh.s on 03/07/17.
 */

public final class DatabaseContracts {

    private DatabaseContracts() {
    }

    public static class AppInfoSchema implements BaseColumns {
        public static final String TABLE_NAME = "app_info";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_ICON_RES_ID = "icon_res_id";
        public static final String COLUMN_PACKAGE_NAME = "package_name";
        public static final String COLUMN_LAUNCH_ACTIVITY = "launch_activity";
    }
}
