package com.pngfi.utils;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.sohu.pumpkin.viewmodel.holder.ViewModelHolder;


public class ActivityUtils {


    public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                             @NonNull Fragment fragment, int containerViewId) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(containerViewId, fragment);
        transaction.commit();
    }


    public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                             @NonNull Fragment fragment, String tag) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(fragment, tag);
        transaction.commit();
    }

    public static <T extends Fragment> T findFragmentById(@NonNull FragmentManager fm, int id){
        T fragment= (T) fm.findFragmentById(id);
        return fragment;
    }

    public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager, int containerViewId,
                                             @NonNull Fragment fragment, String tag) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(containerViewId, fragment, tag);
        transaction.commit();
    }


    public static void hideFragment(@NonNull FragmentManager fragmentManager,
                                    @NonNull Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.hide(fragment);
        transaction.commit();
    }


    public static void showFragment(@NonNull FragmentManager fragmentManager,
                                    @NonNull Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.show(fragment);
        transaction.commit();
    }


    public static <T> T findViewModel(@NonNull FragmentManager fragmentManager, String viewModelTag) {
        // In a configuration change we might have a ViewModel present. It's retained using the
        // Fragment Manager.
        @SuppressWarnings("unchecked")
        ViewModelHolder<T> retainedViewModel =
                (ViewModelHolder<T>) fragmentManager
                        .findFragmentByTag(viewModelTag);

        if (retainedViewModel != null && retainedViewModel.getViewModel() != null) {
            // If the model was retained, return it.
            return retainedViewModel.getViewModel();
        }
        return null;
    }


    public static <T> void addViewModel(FragmentManager fragmentManager, T viewModel, String viewModelTag){
        addFragmentToActivity(fragmentManager,ViewModelHolder.createContainer(viewModel),viewModelTag);
    }

}
