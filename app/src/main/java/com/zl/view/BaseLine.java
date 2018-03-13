package com.zl.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Zhaolei
 * 时间:2018/3/13
 */

public class BaseLine extends LinearLayout {

    private View line_view;

    public BaseLine(Context context) {
        super(context);
    }

    public BaseLine(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOrientation(HORIZONTAL);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.layout_view_line, this);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.BaseLine);
        initTyped(typedArray);
    }

    /**
     * @param typedArray
     */
    private void initTyped(TypedArray typedArray) {
        line_view = findViewById(R.id.line_view);
        TextView line_text = findViewById(R.id.line_text);

        String text = typedArray.getString(R.styleable.BaseLine_text);
        float viewHeight = typedArray.getDimension(R.styleable.BaseLine_view_height, 30);
        float viewWidth = typedArray.getDimension(R.styleable.BaseLine_view_width, 100);


        LayoutParams layoutParams = new LayoutParams((int) viewWidth, (int) viewHeight);
        layoutParams.gravity = Gravity.CENTER_VERTICAL;
        line_view.setLayoutParams(layoutParams);

        line_text.setText(text);
        line_text.setGravity(Gravity.CENTER_VERTICAL);

        typedArray.recycle();
    }

    //设置图片的高度和宽度
    public void setLineSize(int width, int height) {
        LayoutParams layoutParams = new LayoutParams(width, height);
        layoutParams.gravity = Gravity.CENTER_VERTICAL;
        line_view.setLayoutParams(layoutParams);
        invalidate();
    }

    public void setBackGround(Drawable drawable) {
        line_view.setBackground(drawable);
    }


}

