package com.heaven7.android.container;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public interface Container {

    View getView(ViewGroup parent, LayoutInflater inflater);

    View getView();

    void onAttach();

    void onDetach();
}