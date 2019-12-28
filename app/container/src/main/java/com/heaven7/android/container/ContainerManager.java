package com.heaven7.android.container;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * item info
 *
 * @author heaven7
 */
public class ContainerManager{

    private final List<Container> mContainers = new ArrayList<>();
    private final Context mContext;
    private final Callback mCallback;

    public ContainerManager(Context mContext, Callback mCallback) {
        this.mContext = mContext;
        this.mCallback = mCallback;
    }

    public void setupAttribute(TypedArray ta){
        //later will use
    }

    public Context getContext() {
        return mContext;
    }

    public int getContainerSize(){
        return mContainers.size();
    }
    public ContainerManager addChild(Container container) {
        mContainers.add(container);
        mCallback.addView(this, container, -1);
        return this;
    }
    public ContainerManager addChildAt(Container container, int index) {
        mContainers.add(index, container);

        mCallback.addView(this, container, index);
        return this;
    }
    public ContainerManager clearChildren() {
        for (int size = mContainers.size(), i = 0; i < size; i++) {
            mCallback.removeViewAt(this, i);
        }
        mContainers.clear();
        return this;
    }
    public ContainerManager removeChildAt(int index) {
        View view = mContainers.get(index).getView();
        if (view != null) {
            mCallback.removeViewAt(this, index);
        }
        return this;
    }
    public ContainerManager addChildren(List<? extends Container> containers) {
        mContainers.addAll(containers);
        for (Container container : containers){
            mCallback.addView(this, container, -1);
        }
        return this;
    }
    public ContainerManager addContainer(Container container){
        mContainers.add(container);
        return this;
    }
    public ContainerManager addContainerAt(Container container, int index){
        mContainers.add(index, container);
        return this;
    }
    public ContainerManager clearContainers(){
        mContainers.clear();
        return this;
    }
    public ContainerManager removeContainerAt(int index){
        mContainers.remove(index);
        return this;
    }
    public ContainerManager addContainers(List<? extends Container> list){
        mContainers.addAll(list);
        return this;
    }
    public void inflate() {
        for (int size = mContainers.size(), i = 0; i < size; i++) {
            Container container = mContainers.get(i);
            mCallback.addView(this, container, -1);
        }
    }

    public void dispatchChildAttached(int index) {
        //onViewAttachedToWindow
        Container container = mContainers.get(index);
        container.onAttach();
    }

    public void dispatchChildDetached(int index) {
        //onViewDetachedFromWindow
        //ignore
        Container container = mContainers.get(index);
        // Clear any android.view.animation.Animation that may prevent the item from
        // detaching when being removed. If a child is re-added before the
        // lazy detach occurs, it will receive invalid attach/detach sequencing.
        container.getView().clearAnimation();
        container.onDetach();
    }

    public interface Callback{
        void addView(ContainerManager cm, Container container, int index);
        void removeViewAt(ContainerManager cm, int index);
    }
}
