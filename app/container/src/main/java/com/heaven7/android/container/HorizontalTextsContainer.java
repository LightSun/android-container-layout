package com.heaven7.android.container;

import java.util.List;

public class HorizontalTextsContainer extends LinearContainer {

    public HorizontalTextsContainer(int layoutId, int textViewId, List<? extends CharSequence> texts) {
        for (CharSequence cs: texts){
            TextContainer container = new TextContainer();
            container.setLayoutId(layoutId);
            container.setTextViewId(textViewId);
            container.setText(cs);
            addContainer(container);
        }
    }
    public HorizontalTextsContainer(int layoutId, List<? extends CharSequence> texts) {
        this(layoutId, 0, texts);
    }
}
