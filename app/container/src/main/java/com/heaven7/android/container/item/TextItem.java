package com.heaven7.android.container.item;

import com.heaven7.android.container.OnContainerClickListener;

import java.util.ArrayList;
import java.util.List;

public class TextItem {

    private CharSequence text;
    private int layoutId;
    private int textViewId;
    private OnContainerClickListener onContainerClickListener;

    protected TextItem(TextItem.Builder builder) {
        this.text = builder.text;
        this.layoutId = builder.layoutId;
        this.textViewId = builder.textViewId;
        this.onContainerClickListener = builder.onContainerClickListener;
    }
    public static List<TextItem> ofList(int layoutId, int textViewId,
                                        List<? extends CharSequence> texts,
                                        List<? extends OnContainerClickListener> ls){
        if(ls != null){
            if(texts.size() != ls.size()){
                throw new IllegalArgumentException();
            }
        }
        List<TextItem> list = new ArrayList<>();
        for (int i = 0; i < texts.size(); i++) {
            TextItem ti = new TextItem();
            ti.setLayoutId(layoutId);
            ti.setTextViewId(textViewId);
            ti.setText(texts.get(i));
            if(ls != null){
                ti.setOnContainerClickListener(ls.get(i));
            }
            list.add(ti);
        }
        return list;
    }
    public static List<TextItem> ofList(int layoutId, int textViewId, List<? extends CharSequence> texts){
        return ofList(layoutId, textViewId, texts, null);
    }
    public static List<TextItem> ofList(int layoutId, List<? extends CharSequence> texts){
        return ofList(layoutId, 0, texts, null);
    }

    public TextItem(){}

    public void setText(CharSequence text) {
        this.text = text;
    }
    public void setLayoutId(int layoutId) {
        this.layoutId = layoutId;
    }
    public void setTextViewId(int textViewId) {
        this.textViewId = textViewId;
    }
    public void setOnContainerClickListener(OnContainerClickListener onContainerClickListener) {
        this.onContainerClickListener = onContainerClickListener;
    }
    public CharSequence getText() {
        return this.text;
    }
    public int getLayoutId() {
        return this.layoutId;
    }
    public int getTextViewId() {
        return this.textViewId;
    }
    public OnContainerClickListener getOnContainerClickListener() {
        return this.onContainerClickListener;
    }

    public static class Builder {
        private CharSequence text;
        private int layoutId;
        private int textViewId;
        private OnContainerClickListener onContainerClickListener;

        public Builder setText(CharSequence text) {
            this.text = text;
            return this;
        }

        public Builder setLayoutId(int layoutId) {
            this.layoutId = layoutId;
            return this;
        }

        public Builder setTextViewId(int textViewId) {
            this.textViewId = textViewId;
            return this;
        }

        public Builder setOnContainerClickListener(OnContainerClickListener onContainerClickListener) {
            this.onContainerClickListener = onContainerClickListener;
            return this;
        }

        public TextItem build() {
            return new TextItem(this);
        }
    }
}
