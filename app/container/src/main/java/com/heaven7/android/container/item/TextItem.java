package com.heaven7.android.container.item;

import com.heaven7.android.container.OnContainerClickListener;

import java.util.ArrayList;
import java.util.List;

public class TextItem {

    private CharSequence text;
    private OnContainerClickListener onContainerClickListener;

    public static List<TextItem> ofList(List<? extends CharSequence> texts, List<OnContainerClickListener> ls){
        if(ls != null){
            if(texts.size() != ls.size()){
                throw new IllegalArgumentException();
            }
        }
        List<TextItem> list = new ArrayList<>();
        for (int i = 0; i < texts.size(); i++) {
            TextItem ti = new TextItem();
            ti.setText(texts.get(i));
            if(ls != null){
                ti.setOnContainerClickListener(ls.get(i));
            }
            list.add(ti);
        }
        return list;
    }

    public TextItem(CharSequence text, OnContainerClickListener onContainerClickListener) {
        this.text = text;
        this.onContainerClickListener = onContainerClickListener;
    }
    public TextItem(){}

    public void setText(CharSequence text) {
        this.text = text;
    }
    public void setOnContainerClickListener(OnContainerClickListener onContainerClickListener) {
        this.onContainerClickListener = onContainerClickListener;
    }
    public CharSequence getText() {
        return text;
    }
    public OnContainerClickListener getOnContainerClickListener() {
        return onContainerClickListener;
    }
}
