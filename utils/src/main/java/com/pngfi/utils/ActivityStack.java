package com.pngfi.utils;

import android.app.Activity;

import java.util.LinkedList;

/**
 * Created by pngfi on 2018/4/19.
 */

public class ActivityStack {

    private static ActivityStack sInstance=new ActivityStack();

    public static ActivityStack getInstance(){
        return sInstance;
    }

    private LinkedList<Activity> activities=new LinkedList<>();

    public void addActivity(Activity activity){
        activities.add(activity);
    }

    public void removeActivity(Activity activity){
        activities.remove(activity);
    }

    public boolean isEmpty(){
        return activities.isEmpty();
    }
}
