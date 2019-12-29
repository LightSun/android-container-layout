package com.heaven7.android.container.factory;

import com.heaven7.android.container.OnContainerClickListener;
import com.heaven7.android.container.TextContainer;

public class TextContainerFactory implements ITextContainerFactory {

    private int mLayoutId;
    private int mTextViewId;
    private CharSequence mText;
    private OnContainerClickListener mClickListener;

    protected TextContainerFactory(TextContainerFactory.Builder builder) {
        this.mLayoutId = builder.mLayoutId;
        this.mTextViewId = builder.mTextViewId;
        this.mText = builder.mText;
        this.mClickListener = builder.mClickListener;
    }

    @Override
    public TextContainer create() {
        TextContainer container = new TextContainer();
        container.setLayoutId(mLayoutId);
        container.setTextViewId(mTextViewId);
        container.setText(mText);
        container.setOnContainerClickListener(mClickListener);
        return container;
    }
    public int getLayoutId() {
        return this.mLayoutId;
    }

    public int getTextViewId() {
        return this.mTextViewId;
    }

    public CharSequence getText() {
        return this.mText;
    }

    public OnContainerClickListener getClickListener() {
        return this.mClickListener;
    }
    public static class Builder {
        private int mLayoutId;
        private int mTextViewId;
        private CharSequence mText;
        private OnContainerClickListener mClickListener;

        public Builder setLayoutId(int mLayoutId) {
            this.mLayoutId = mLayoutId;
            return this;
        }

        public Builder setTextViewId(int mTextViewId) {
            this.mTextViewId = mTextViewId;
            return this;
        }

        public Builder setText(CharSequence mText) {
            this.mText = mText;
            return this;
        }

        public Builder setClickListener(OnContainerClickListener mClickListener) {
            this.mClickListener = mClickListener;
            return this;
        }

        public TextContainerFactory build() {
            return new TextContainerFactory(this);
        }
    }
}
