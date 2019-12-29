package com.heaven7.android.container;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import static android.widget.LinearLayout.HORIZONTAL;

public class LinearContainer extends MultiContainer {

    private int orientation;

    public LinearContainer(int orientation) {
        super();
        this.orientation = orientation;
    }

    public LinearContainer() {
        this(HORIZONTAL);
    }

    protected ViewGroup.LayoutParams generateLayoutParams() {
        return new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }
    @Override
    protected ViewGroup createLayout(ViewGroup parent, LayoutInflater inflater) {
        LinearLayout layout = new LinearLayout(parent.getContext());
        layout.setOrientation(orientation);
        layout.setLayoutParams(generateLayoutParams());
        return layout;
    }

}