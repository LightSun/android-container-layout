package com.heaven7.android.container;

import com.heaven7.android.container.factory.IMultiTextContainerFactory;
import com.heaven7.android.container.factory.MultiTextContainerFactory;
import com.heaven7.android.container.item.TextItem;

import java.util.List;

public class TextListContainer extends LinearContainer {

    public TextListContainer(IMultiTextContainerFactory factory) {
        super();
        addContainers(factory.create());
    }
    public TextListContainer(int layoutId, List<? extends CharSequence> texts) {
        this(layoutId, texts, null);
    }
    public TextListContainer(int layoutId, List<? extends CharSequence> texts, List<OnContainerClickListener> ls) {
        this(new MultiTextContainerFactory.Builder()
                .setLayoutId(layoutId)
                .setItems(TextItem.ofList(texts, ls))
                .build());
    }
}
