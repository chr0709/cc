package com.example.a1.event;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

// 即 事件传递的顺序：Activity -> ViewGroup -> View
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private MyView mv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, "dispatchTouchEvent: " + ev.getAction());
        //true  消费了
        //false  无处理
        // super.dispatchTouchEvent(ev)事件才会向子view分发
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent: " + event.getAction());
        //true 消费事件
        //false  不处理
        return super.onTouchEvent(event);
    }

    private void initView() {
        mv = (MyView) findViewById(R.id.mv);
        mv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d(TAG, "onTouch: ");
//                04-17 13:16:50.221 4734-4734/com.example.a1.event D/MainActivity: dispatchTouchEvent: 0
//                04-17 13:16:50.231 4734-4734/com.example.a1.event D/MyViewGroup: dispatchTouchEvent: 0
//                04-17 13:16:50.231 4734-4734/com.example.a1.event D/MyViewGroup: onInterceptTouchEvent: 0
//                04-17 13:16:50.231 4734-4734/com.example.a1.event D/MyView: dispatchTouchEvent: 0
//                04-17 13:16:50.231 4734-4734/com.example.a1.event D/MainActivity: onTouch:
//                04-17 13:16:50.231 4734-4734/com.example.a1.event D/MyView: onTouchEvent: 0

                return false;
            }
        });
    }
}
