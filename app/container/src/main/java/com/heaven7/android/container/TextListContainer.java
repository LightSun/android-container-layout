package com.heaven7.android.container;

import com.heaven7.android.container.factory.ITextContainerFactory;
import com.heaven7.android.container.factory.TextContainerFactory;
import com.heaven7.android.container.item.TextItem;

import java.util.List;

public class TextListContainer extends LinearContainer {

    public TextListContainer(List<TextItem> list, ITextContainerFactory factory) {
        super();
        if(factory == null){
            factory = TextContainerFactory.DEFAULT;
        }
        for (TextItem ti : list){
            TextContainer container = factory.create();
            container.setItem(ti);
            addContainer(container);
        }
    }
    public TextListContainer(int layoutId, int textViewId,
                             List<? extends CharSequence> texts,
                             List<? extends OnContainerClickListener> ls) {
        this(TextItem.ofList(layoutId, textViewId,texts, ls), null);
    }
    public TextListContainer(int layoutId, int textViewId ,List<? extends CharSequence> texts) {
        this(TextItem.ofList(layoutId, textViewId, texts), null);
    }
    public TextListContainer(int layoutId,List<? extends CharSequence> texts) {
        this(TextItem.ofList(layoutId, texts), null);
    }
}
