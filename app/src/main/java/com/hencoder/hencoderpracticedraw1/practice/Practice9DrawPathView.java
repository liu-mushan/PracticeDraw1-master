package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {
    private Paint paint;
    private Path path;

    public Practice9DrawPathView(Context context) {
        this(context, null);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        path = new Path();
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //        练习内容：使用 canvas.drawPath() 方法画心形
        path.arcTo(canvas.getWidth() / 2 - 200, 380, canvas.getWidth() / 2, 580, 135, 225, false);
        path.arcTo(canvas.getWidth() / 2, 380, canvas.getWidth() / 2 + 200, 580, 180, 225, false);
        path.lineTo(canvas.getWidth() / 2, 720);
        path.close();
        canvas.drawPath(path, paint);
    }
}
