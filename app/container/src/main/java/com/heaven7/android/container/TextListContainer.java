package com.heaven7.android.container;

import android.widget.LinearLayout;

import com.heaven7.android.container.factory.TextContainerFactory;

import java.util.List;

public class TextListContainer extends LinearContainer {

   /* private TextContainerFactory textContainerFactory;
    private int layoutId;
    private int textViewId;
    private List<? extends CharSequence> texts;*/

    public TextListContainer(TextListContainer.Builder builder) {
        super(builder.orientation);
        for (CharSequence cs: builder.texts){
            TextContainerFactory factory = builder.textContainerFactory;
            TextContainer container = factory != null ? factory.createTextContainer() : new TextContainer();
            container.setLayoutId(builder.layoutId);
            container.setTextViewId(builder.textViewId);
            container.setText(cs);
            addContainer(container);
        }
    }
    public TextListContainer(int layoutId, int textViewId, List<? extends CharSequence> texts) {
        this(new Builder()
                .setLayoutId(layoutId)
                .setTextViewId(textViewId)
                .setTexts(texts)
        );
    }
    public TextListContainer(int layoutId, List<? extends CharSequence> texts) {
        this(layoutId, 0, texts);
    }

    public static class Builder {
        private TextContainerFactory textContainerFactory;
        private int orientation = LinearLayout.VERTICAL;
        private int layoutId;
        private int textViewId;
        private List<? extends CharSequence> texts;

        public Builder setTextContainerFactory(TextContainerFactory textContainerFactory) {
            this.textContainerFactory = textContainerFactory;
            return this;
        }
        public Builder setOrientation(int orientation) {
            this.orientation = orientation;
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

        public Builder setTexts(List<? extends CharSequence> texts) {
            this.texts = texts;
            return this;
        }
        public TextListContainer build() {
            return new TextListContainer(this);
        }
    }
}
