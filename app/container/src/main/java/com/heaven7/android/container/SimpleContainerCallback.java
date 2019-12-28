package com.heaven7.android.container;

import android.view.LayoutInflater;
import android.view.ViewGroup;

public class SimpleContainerCallback implements ContainerManager.Callback {

    private final ViewGroup parent;

    public SimpleContainerCallback(ViewGroup parent) {
        this.parent = parent;
    }

    @Override
    public void addView(ContainerManager cm, Container container, int index) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if(index >=0 ){
            parent.addView(container.getView(parent, inflater), index);
        }else {
            parent.addView(container.getView(parent, inflater));
        }
    }
    @Override
    public void removeViewAt(ContainerManager cm, int index) {
        parent.removeViewAt(index);
    }
}
