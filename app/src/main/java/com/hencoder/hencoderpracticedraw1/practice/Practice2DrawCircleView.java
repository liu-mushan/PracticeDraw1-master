package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice2DrawCircleView extends View {
    private Paint paint;

    public Practice2DrawCircleView(Context context) {
        super(context);
        init();
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(Color.BLACK);
        canvas.drawCircle(canvas.getWidth() / 2 - 200 - 50, 200,
                200, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
        canvas.drawCircle(canvas.getWidth() / 2 + 50 + 200, 200,
                200, paint);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(canvas.getWidth() / 2 - 200 - 50, 400 + 50 + 200,
                200, paint);

        paint.setStrokeWidth(80);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(canvas.getWidth() / 2 + 50 + 200, 400 + 50 + 200,
                200, paint);
    }
}
