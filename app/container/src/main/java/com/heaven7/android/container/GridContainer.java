package com.heaven7.android.container;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.GridLayout;

import com.heaven7.android.container.item.GridItem;

public class GridContainer extends MultiContainer {

    private GridItem item;

    public GridItem getItem() {
        return item;
    }
    public void setItem(GridItem item) {
        this.item = item;
    }

    @Override
    protected ViewGroup createLayout(ViewGroup parent, LayoutInflater inflater){
        GridLayout gl = new GridLayout(parent.getContext());
        gl.setColumnCount(item.getColumnCount());
        gl.setRowCount(item.getRowCount());
        gl.setOrientation(item.getOrientation());
        return gl;
    }

}