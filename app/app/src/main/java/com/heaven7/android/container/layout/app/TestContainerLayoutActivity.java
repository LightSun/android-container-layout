package com.heaven7.android.container.layout.app;

import android.content.Context;
import android.os.Bundle;


import com.heaven7.android.container.ContainerLinearLayout;
import com.heaven7.android.container.TextListContainer;

import java.util.Arrays;

import butterknife.BindView;

public class TestContainerLayoutActivity extends BaseActivity {

    @BindView(R.id.vg_container)
    ContainerLinearLayout mContainer;

    @Override
    protected int getLayoutId() {
        return R.layout.ac_test_container;
    }
    @Override
    protected void onInit(Context context, Bundle savedInstanceState) {

        mContainer.addChild(new TextListContainer(R.layout.container_simple_text,
                Arrays.asList("Hello World!",
                        "Hello Goggle!",
                        "Hello Container Layout")));
    }
}
