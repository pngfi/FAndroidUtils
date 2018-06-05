package com.pngfi.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodManager;

public final class DisplayUtils {

    /**
     * Don't let anyone instantiate this class.
     */
    private DisplayUtils() {
        throw new Error("Do not need instantiate!");
    }


    private static Context sContext;


    public static void init(Context context) {
        sContext = context;
    }


    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     *
     * @param dpValue 尺寸dip
     * @return 像素值
     */
    public static int dip2px(float dpValue) {
        final float scale = sContext.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     *
     * @param pxValue 尺寸像素
     * @return DIP值
     */
    public static int px2dip(float pxValue) {
        final float scale = sContext.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 sp
     *
     * @param pxValue 尺寸像素
     * @return SP值
     */
    public static int px2sp(float pxValue) {
        float fontScale = sContext.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 sp 的单位 转成为 px
     *
     * @param spValue SP值
     * @return 像素值
     */
    public static int sp2px(float spValue) {
        float fontScale = sContext.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * 获取dialog宽度
     *
     * @param activity Activity
     * @return Dialog宽度
     */
    public static int getDialogW(Activity activity) {
        DisplayMetrics dm;
        dm = activity.getResources().getDisplayMetrics();
        int w = dm.widthPixels - 100;
        return w;
    }

    /**
     * 获取屏幕宽度
     *
     * @return 屏幕宽度
     */
    public static int getScreenW() {

        return sContext.getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * 获取屏幕高度
     *
     * @return 屏幕高度
     */
    public static int getScreenH() {
        DisplayMetrics dm = sContext.getResources().getDisplayMetrics();
        int h = dm.heightPixels;
        return h;
    }

    /**
     * Toggle keyboard If the keyboard is visible,then hidden it,if it's
     * invisible,then show it
     *
     * @param context 上下文
     */
    public static void toggleKeyboard(Context context) {
        InputMethodManager imm = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive()) {
            imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT,
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }


    public static int getStatusBarHeight() {
        int statusBarHeight = -1;
        //获取status_bar_height资源的ID
        int resourceId = sContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            //根据资源ID获取响应的尺寸值
            statusBarHeight = sContext.getResources().getDimensionPixelSize(resourceId);
        }
        return statusBarHeight;
    }


    public  static int getNavigationBarHeight() {
        Resources resources = sContext.getResources();
        int resourceId=resources.getIdentifier("navigation_bar_height","dimen","android");
        int height = resources.getDimensionPixelSize(resourceId);
        return height;
    }


}