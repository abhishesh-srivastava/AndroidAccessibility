package com.codebyte.quickapps.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by abhishesh.s on 03/07/17.
 */

public class DbHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "AppInfoDb";

    private static final String SQL_CREATE_TABLE_CMD =
            "CREATE TABLE " + DatabaseContracts.AppInfoSchema.TABLE_NAME + " (" +
                    DatabaseContracts.AppInfoSchema._ID + " INTEGER PRIMARY KEY," +
                    DatabaseContracts.AppInfoSchema.COLUMN_ICON_RES_ID + " INTEGER," +
                    DatabaseContracts.AppInfoSchema.COLUMN_PACKAGE_NAME + " TEXT," +
                    DatabaseContracts.AppInfoSchema.COLUMN_LAUNCH_ACTIVITY + " TEXT)";

    private static final String SQL_DELETE_TABLE_CMD =
            "DROP TABLE IF EXISTS " + DatabaseContracts.AppInfoSchema.TABLE_NAME;

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_CMD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            db.execSQL(SQL_DELETE_TABLE_CMD);
            onCreate(db);
        }
    }
}
