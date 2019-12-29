package com.heaven7.android.container;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.GridLayout;

public class GridContainer extends MultiContainer {

    private int columnCount;
    private int rowCount;
    private int orientation = GridLayout.VERTICAL;

    public int getColumnCount() {
        return columnCount;
    }
    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    @Override
    protected ViewGroup createLayout(ViewGroup parent, LayoutInflater inflater){
        GridLayout gl = new GridLayout(parent.getContext());
        gl.setColumnCount(columnCount);
        gl.setRowCount(rowCount);
        gl.setOrientation(orientation);
        return gl;
    }

}