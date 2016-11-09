package com.glemontree.popupview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/11/9.
 */

public class PopupView extends View {
    private int mWidth, mHeight, mRectWidth, mRectHeight;
    private double mRectPercent = 0.8;
    public PopupView(Context context) {
        this(context, null);
    }
    public PopupView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public PopupView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        if (widthMode == MeasureSpec.EXACTLY) {
            mWidth = widthSize;
            mRectWidth = (int) (mWidth * mRectPercent);
        }
        if (heightMode == MeasureSpec.EXACTLY) {
            mHeight = heightSize;
            mRectHeight = (int) (mHeight * mRectPercent + 0.1);
        }
        setMeasuredDimension(mWidth, mHeight);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        Paint p = new Paint();
        p.setColor(Color.parseColor("#2C97DE"));
        p.setStyle(Paint.Style.FILL);
        canvas.drawRoundRect(new RectF(0, 0, mRectWidth, mRectHeight), 10, 10, p);

        Path path = new Path();
        path.moveTo(mRectWidth/2 - 30, mRectHeight);
        path.lineTo(mRectWidth/2, mRectHeight + 20);
        path.lineTo(mRectWidth/2 + 30, mRectHeight);
        path.close();
        canvas.drawPath(path, p);
        super.onDraw(canvas);
    }
}
