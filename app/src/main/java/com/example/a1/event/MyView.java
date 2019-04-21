package com.example.a1.event;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by 1 on 2019/4/17.
 */

public class MyView extends View {
    private static final String TAG = "MyView";

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d(TAG, "dispatchTouchEvent: " + event.getAction());
        //super.dispatchTouchEvent(event)  执行下一步  onTouchEvent
        //true  事件被消费
        //false  ==>ViewGroup 的onTouchEvent  Activity  == 》onTouchEvent  事件无处理
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent: " + event.getAction());
        //super.dispatchTouchEvent(event)  false  ==>ViewGroup 的onTouchEvent  Activity  == 》onTouchEvent  事件无处理
        //true   事件被消费
        return super.onTouchEvent(event);
    }

}
