package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice4DrawPointView extends View {
    private Paint paint;

    public Practice4DrawPointView(Context context) {
        this(context, null);
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //练习内容：使用 canvas.drawPoint() 方法画点
        //一个圆点，一个方点
        //圆点和方点的切换使用 paint.setStrokeCap(cap)：`ROUND` 是圆点，`BUTT` 或 `SQUARE` 是方点
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setStrokeWidth(100);

        canvas.drawPoint(canvas.getWidth() / 2 - 200, canvas.getHeight() / 2, paint);

        paint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawPoint(canvas.getWidth() / 2 + 200, canvas.getHeight() / 2, paint);
    }
}
