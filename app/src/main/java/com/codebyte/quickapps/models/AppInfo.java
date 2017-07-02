package com.codebyte.quickapps.models;

/**
 * Created by abhishesh.s on 02/07/17.
 */

public class AppInfo {
    private String mName;
    private int mIcon;
    private boolean isAdded;
    private String mPackageName;
    private String mDefaultActivity;


    public AppInfo(String name, int iconId, boolean value) {
        mName = name;
        mIcon = iconId;
        isAdded = value;
    }

    public AppInfo(AppInfo.Builder builder) {
        mName = builder.mName;
        mIcon = builder.mIcon;
        mPackageName = builder.mPackageName;
        mDefaultActivity = builder.mDefaultActivity;
    }

    public int getIcon() {
        return mIcon;
    }

    public String getName() {
        return mName;
    }

    public boolean isAdded() {
        return isAdded;
    }

    public String getPackageName() {
        return mPackageName;
    }

    public String getDefaultActivity() {
        return mDefaultActivity;
    }

    public static class Builder {
        private String mName;
        private int mIcon;
        private boolean isAdded;
        private String mPackageName;
        private String mDefaultActivity;

        public Builder addName(String name) {
            mName = name;
            return this;
        }

        public Builder addIcon(int iconId) {
            mIcon = iconId;
            return this;
        }

        public Builder addPackageName(String pName) {
            mPackageName = pName;
            return this;
        }

        public Builder addDefaultActivity(String name) {
            mDefaultActivity = name;
            return this;
        }

        public AppInfo build() {
            return new AppInfo(this);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(mName).append(" ").append(mDefaultActivity).append(" ").append(mIcon).append(" ").append(mPackageName);
        return sb.toString();
    }
}
