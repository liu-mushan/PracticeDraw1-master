package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.DensityUtil;

public class Practice7DrawRoundRectView extends View {
    private Paint paint;
    private Context context;

    public Practice7DrawRoundRectView(Context context) {
        this(context, null);
    }

    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //练习内容：使用 canvas.drawRoundRect() 方法画圆角矩形
        RectF rectF = new RectF(canvas.getWidth() / 2 - 300, canvas.getHeight() / 2 - 150, canvas.getWidth() / 2 + 300, canvas.getHeight() / 2 + 150);
        canvas.drawRoundRect(rectF, DensityUtil.dip2px(context, 20), DensityUtil.dip2px(context, 20), paint);
    }
}
