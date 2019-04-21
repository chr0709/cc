package com.example.a1.event;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by 1 on 2019/4/17.
 */

public class MyViewGroup extends LinearLayout {
    private static final String TAG = "MyViewGroup";
    private float mDownX;
    private float mDownY;
    private float mMoveX;
    private float mMoveY;

    public MyViewGroup(Context context) {
        super(context);
    }

    public MyViewGroup(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, "dispatchTouchEvent: " + ev.getAction());
        //true  事件消费 未分发
        //false  事件发送到父容器 onTouchEvent
        //super.dispatchTouchEvent(ev),继续执行onInterceptTouchEvent
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(TAG, "onInterceptTouchEvent: " + ev.getAction());
        //false / super.onInterceptTouchEvent(ev)。事件未拦截 发送到子view 的  dispatchTouchEvent
        //true  执行下一步方法  onTouchEvent===》Activity 的 onTouchEvent  无处理

        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mDownX = ev.getX();
                mDownY = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                mMoveX = ev.getX();
                mMoveY = ev.getY();

                float dx = mMoveX - mDownX;
                float dy = mMoveY - mDownY;
                if (Math.abs(dx) >= Math.abs(dy)) {
                    // 水平滑动 发送给子View
                    return true;
                } else {
                    // 垂直滑动    拦截 自己使用
                    return false;
                }
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent: " + event.getAction());
        //false / super.onInterceptTouchEvent(ev)。onTouchEvent===》Activity 的 onTouchEvent  无处理
        // true  事件被消费
        return super.onTouchEvent(event);
    }

}
