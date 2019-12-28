package com.heaven7.android.container;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class MultiContainer extends BaseContainer {

    private List<Container> cells;

    public MultiContainer(){
        this.cells = new ArrayList<>();
    }
    public List<Container> getContainers(){
        return cells;
    }
    public void addContainer(Container container){
        cells.add(container);
    }
    public void removeContainer(Container container){
        cells.remove(container);
    }

    protected abstract ViewGroup createLayout(ViewGroup parent, LayoutInflater inflater);

    @Override
    protected View onCreateView(ViewGroup parent, LayoutInflater inflater) {
        ViewGroup layout = createLayout(parent, inflater);
        for (Container cell : cells) {
            layout.addView(cell.getView(layout, inflater));
        }
        return layout;
    }

    @Override
    public void onAttach() {
        for (int size1 = cells.size(), i = 0; i < size1; i++) {
            cells.get(i).onAttach();
        }
    }

    @Override
    public void onDetach() {
        for (int size1 = cells.size(), i = 0; i < size1; i++) {
            cells.get(i).onDetach();
        }
    }
}