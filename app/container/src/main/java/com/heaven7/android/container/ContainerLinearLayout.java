package com.heaven7.android.container;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.List;

/**
 * item info
 *
 * @author heaven7
 */
public class ContainerLinearLayout extends LinearLayout{

    private ContainerManager mCM;

    public ContainerLinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ContainerLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mCM = new ContainerManager(context, new SimpleContainerCallback(this));
       /* TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ContainerLayout);
        try {

        } finally {
            a.recycle();
        }*/
    }
    public ContainerManager getContainerManager(){
        return mCM;
    }
    public int getContainerSize(){
        return mCM.getContainerSize();
    }
    public ContainerLinearLayout addChild(Container container) {
         mCM.addChild(container);
         return this;
    }
    public ContainerLinearLayout addChildAt(Container container, int index) {
        mCM.addChildAt(container, index);
        return this;
    }
    public ContainerLinearLayout clearChildren() {
        mCM.clearChildren();
        return this;
    }
    public ContainerLinearLayout removeChildAt(int index) {
        mCM.removeChildAt(index);
        return this;
    }
    public ContainerLinearLayout addChildren(List<? extends Container> containers) {
        mCM.addChildren(containers);
        return this;
    }
    public ContainerLinearLayout addContainer(Container container){
        mCM.addContainer(container);
        return this;
    }
    public ContainerLinearLayout addContainerAt(Container container, int index){
        mCM.addContainerAt(container, index);
        return this;
    }
    public ContainerLinearLayout clearContainers(){
        mCM.clearContainers();
        return this;
    }
    public ContainerLinearLayout removeContainerAt(int index){
        mCM.removeContainerAt(index);
        return this;
    }
    public ContainerLinearLayout addContainers(List<? extends Container> list){
        mCM.addContainers(list);
        return this;
    }
    public void inflate() {
        mCM.inflate();
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        //if call addView(child). index is -1.
        if(index == -1){
            index = getChildCount() - 1;
        }
        mCM.dispatchChildAttached(index);
    }
    @Override
    public void removeViewAt(int index) {
        mCM.dispatchChildDetached(index);
        super.removeViewAt(index);
    }

}
