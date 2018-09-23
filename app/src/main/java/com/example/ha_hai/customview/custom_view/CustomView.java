package com.example.ha_hai.customview.custom_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by ha_hai on 9/16/2018.
 */

public class CustomView extends View {

    int color = Color.RED;

    private Paint mPaint;

    public CustomView(Context context) {
        super(context);

        setPaint();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setPaint();

    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = MeasureSpec.getSize(widthMeasureSpec);
        int wMode = MeasureSpec.getMode(widthMeasureSpec);

        int height = MeasureSpec.getSize(heightMeasureSpec);
        int hMode = MeasureSpec.getMode(heightMeasureSpec);

        if (wMode == MeasureSpec.EXACTLY) {
            Log.d("AAA", "wMode: EXACTLY");
        } else if (wMode == MeasureSpec.AT_MOST) {
            Log.d("AAA", "wMode: AT_MOST");

        } else if (wMode == MeasureSpec.UNSPECIFIED) {
            Log.d("AAA", "wMode: UNSPECIFIED");

        }

        if (hMode == MeasureSpec.EXACTLY) {
            Log.d("AAA", "hMode: EXACTLY");
        } else if (hMode == MeasureSpec.AT_MOST) {
            Log.d("AAA", "hMode: AT_MOST");

        } else if (hMode == MeasureSpec.UNSPECIFIED) {
            Log.d("AAA", "hMode: UNSPECIFIED");

        }

        Log.d("AAA", "width: " + width + " - height: " + height);


        setMeasuredDimension(width, height);
    }

    private void setPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(color);
        mPaint.setStyle(Paint.Style.FILL);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        canvas.drawRect(new Rect(0, 0, 200, 200), mPaint);

        canvas.translate(300, 300);
        canvas.drawCircle(0, 0, 50,  mPaint);
        canvas.restore();

        canvas.drawRect(0, 50 , 150, 300, mPaint);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        Log.d("AAA", "Layout: width: " + getMeasuredWidth() + " - height: " + getMeasuredHeight());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
