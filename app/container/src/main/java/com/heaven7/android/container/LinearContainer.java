package com.heaven7.android.container;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import static android.widget.LinearLayout.HORIZONTAL;

public class LinearContainer extends MultiContainer {

    private int orientation = HORIZONTAL;

    public LinearContainer() {
        super();
    }
    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }
    public int getOrientation() {
        return orientation;
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