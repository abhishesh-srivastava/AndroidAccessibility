package com.codebyte.quickapps;

/**
 * Created by abhishesh.s on 02/07/17.
 */

public interface AsyncCallback {
    public void onSuccess();

    public void onError(int errorCode, String errorReason);
}
