package com.example.ha_hai.customview.custom_view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.ha_hai.customview.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by ha_hai on 9/16/2018.
 */

public class CustomView extends View {

    int color = Color.RED;

    private Paint mPaint;
    private int mWidth, mHeight;
    private CircleImageView circleImageView;

    public CustomView(Context context) {
        super(context);

        setPaint();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        setPaint();
//        getSizeScreen(context);
        inflaterCircleImageView(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        setMeasuredDimension(width, height);
    }

    private void setPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(color);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    private void getSizeScreen(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        mHeight = displayMetrics.heightPixels;
        mWidth = displayMetrics.widthPixels;
    }

    private void inflaterCircleImageView(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        circleImageView = (CircleImageView) inflater.inflate(R.layout.custom_view, null);
        circleImageView.measure(MeasureSpec.getSize(circleImageView.getMeasuredWidth()), MeasureSpec.getSize(circleImageView.getMeasuredHeight()));
        circleImageView.layout(0, 0, 400, 400);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(mWidth / 2 - 200, mHeight / 2 - 200);
        circleImageView.draw(canvas);
        canvas.drawCircle(0, 0, 300, mPaint);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        mWidth = getWidth();
        mHeight = getHeight();
    }
}
