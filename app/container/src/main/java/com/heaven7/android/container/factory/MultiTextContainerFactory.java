package com.heaven7.android.container.factory;

import com.heaven7.android.container.TextContainer;
import com.heaven7.android.container.item.TextItem;

import java.util.ArrayList;
import java.util.List;

public class MultiTextContainerFactory implements IMultiTextContainerFactory {

    private int mLayoutId;
    private int mTextViewId;
    private List<TextItem> items;

    protected MultiTextContainerFactory(MultiTextContainerFactory.Builder builder) {
        this.mLayoutId = builder.mLayoutId;
        this.mTextViewId = builder.mTextViewId;
        this.items = builder.items;
    }

    @Override
    public List<TextContainer> create() {
        List<TextContainer> list = new ArrayList<>();
        for (TextItem item : items){
            TextContainer container = new TextContainer();
            container.setLayoutId(mLayoutId);
            container.setTextViewId(mTextViewId);
            container.setText(item.getText());
            container.setOnContainerClickListener(item.getOnContainerClickListener());
            list.add(container);
        }
        return list;
    }

    public int getLayoutId() {
        return this.mLayoutId;
    }

    public int getTextViewId() {
        return this.mTextViewId;
    }

    public List<TextItem> getItems() {
        return this.items;
    }

    public static class Builder {
        private int mLayoutId;
        private int mTextViewId;
        private List<TextItem> items;

        public Builder setLayoutId(int mLayoutId) {
            this.mLayoutId = mLayoutId;
            return this;
        }
        public Builder setTextViewId(int mTextViewId) {
            this.mTextViewId = mTextViewId;
            return this;
        }
        public Builder setItems(List<TextItem> items) {
            this.items = items;
            return this;
        }
        public Builder addItem(TextItem item){
            if(items == null){
                items = new ArrayList<>();
            }
            items.add(item);
            return this;
        }
        public Builder addItems(List<TextItem> list){
            if(items == null){
                items = new ArrayList<>();
            }
            items.addAll(list);
            return this;
        }
        public MultiTextContainerFactory build() {
            return new MultiTextContainerFactory(this);
        }
    }
}
