package com.heaven7.android.container.item;

import com.heaven7.android.container.CConstant;


public class GridItem {

    private int columnCount;
    private int rowCount;
    private int orientation = CConstant.VERTICAL;

    public GridItem(){}
    protected GridItem(GridItem.Builder builder) {
        this.columnCount = builder.columnCount;
        this.rowCount = builder.rowCount;
        this.orientation = builder.orientation;
    }

    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }
    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }
    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public int getColumnCount() {
        return this.columnCount;
    }
    public int getRowCount() {
        return this.rowCount;
    }
    public int getOrientation() {
        return this.orientation;
    }

    public static class Builder {
        private int columnCount;
        private int rowCount;
        private int orientation = CConstant.VERTICAL;

        public Builder setColumnCount(int columnCount) {
            this.columnCount = columnCount;
            return this;
        }

        public Builder setRowCount(int rowCount) {
            this.rowCount = rowCount;
            return this;
        }

        public Builder setOrientation(int orientation) {
            this.orientation = orientation;
            return this;
        }

        public GridItem build() {
            return new GridItem(this);
        }
    }
}
