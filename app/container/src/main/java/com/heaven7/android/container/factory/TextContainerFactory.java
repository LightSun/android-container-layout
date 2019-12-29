package com.heaven7.android.container.factory;

import com.heaven7.android.container.TextContainer;

public final class TextContainerFactory implements ITextContainerFactory {

    public static final TextContainerFactory DEFAULT = new TextContainerFactory();

    @Override
    public TextContainer create() {
        return new TextContainer();
    }
}
