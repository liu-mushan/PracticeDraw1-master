package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice5DrawOvalView extends View {
    private Paint paint;

    public Practice5DrawOvalView(Context context) {
        this(context, null);
    }

    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.paint = new Paint();
        this.paint.setColor(Color.BLACK);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //练习内容：使用 canvas.drawOval() 方法画椭圆
        RectF rect = new RectF(canvas.getWidth() / 2 - 200, canvas.getHeight() / 2 - 100,
                canvas.getWidth() / 2 + 200, canvas.getHeight() / 2 + 100);
        canvas.drawOval(rect, paint);
    }
}
