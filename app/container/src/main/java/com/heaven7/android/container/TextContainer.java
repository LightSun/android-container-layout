package com.heaven7.android.container;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.heaven7.android.container.item.TextItem;

public class TextContainer extends BaseContainer {

    private TextItem item;

    public TextItem getItem() {
        return item;
    }
    public void setItem(TextItem item) {
        this.item = item;
    }

    public TextView getTextView(){
        final View view = getView();
        int textViewId = item.getTextViewId();
        TextView tv;
        if (textViewId == 0) {
            tv = (TextView) view;
        } else {
            tv = view.findViewById(textViewId);
        }
        return tv;
    }
    @Override
    public View onCreateView(ViewGroup parent, LayoutInflater layoutInflater) {
        return layoutInflater.inflate(item.getLayoutId(), parent, false);
    }
    @Override
    public void onAttach() {
        TextView view = getTextView();
        view.setText(item.getText());
        if(item.getOnContainerClickListener() != null){
            getView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    item.getOnContainerClickListener().onClick(TextContainer.this, view);
                }
            });
        }
    }
    @Override
    public void onDetach() {
        if(item.getOnContainerClickListener() != null){
            getView().setOnClickListener(null);
        }
    }
}
//animate test ok on onAttach.
/*view.post(new Runnable() {
            @Override
            public void run() {
                view.animate()
                        .scaleX(2)
                        .scaleY(2)
                        .setDuration(2000)
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationStart(Animator animation) {
                                view.setPivotX(0);
                                view.setPivotY(0);
                            }
                        })
                        .setUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            int width = 0;
                            int height = 0;
                            @Override
                            public void onAnimationUpdate(ValueAnimator animation) {
                                Float val = (Float) animation.getAnimatedValue();
                                ViewGroup.LayoutParams lp = view.getLayoutParams();
                                if(width == 0){
                                    width = view.getMeasuredWidth();
                                    height = view.getMeasuredHeight();
                                }
                                lp.width = (int) (width * (1 + val));
                                lp.height = (int) (height * (1 + val));
                                view.setLayoutParams(lp);
                                System.out.println(lp.width);
                            }
                        }).start();
            }
        });*/