package com.happycoderz.espa.helper;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.happycoderz.espa.BuildConfig;

public class CacheHelper {

    private static CacheHelper objectCache;
    private Context context;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private static Gson GSON = new Gson();
    private static final String LOG_TAG = "CacheHelper";
    private static final String PREFERENCES_NAME = BuildConfig.APPLICATION_ID;
    private static final int PREFERENCES_MODE = Activity.MODE_PRIVATE;

    public CacheHelper(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(PREFERENCES_NAME, PREFERENCES_MODE);
        editor = preferences.edit();
    }

    public static CacheHelper getInstance(Context context) {
        if (objectCache == null) {
            objectCache = new CacheHelper(context);
        }
        return objectCache;
    }

    public void putObject(String key, Object object) {
        editor.putString(key, GSON.toJson(object));
        editor.commit();
    }

    public void commit() {
        editor.commit();
    }

    public <T> T getObject(String key, Class<T> a) {
        String gson = preferences.getString(key, null);
        if (gson == null) {
            return null;
        } else {
            try {
                return GSON.fromJson(gson, a);
            } catch (Exception e) {
                throw e;
            }
        }
    }

    public void removeObject(String key) {
        editor.remove(key);
        editor.commit();
    }
}