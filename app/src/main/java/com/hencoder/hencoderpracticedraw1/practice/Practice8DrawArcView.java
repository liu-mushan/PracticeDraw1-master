package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.DensityUtil;

public class Practice8DrawArcView extends View {
    private Paint paint;
    private Context context;

    public Practice8DrawArcView(Context context) {
        this(context, null);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        paint = new Paint();
        paint.setStrokeWidth(1);
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        RectF rectF = new RectF(DensityUtil.dip2px(context, 100), DensityUtil.dip2px(context, 100),
                DensityUtil.dip2px(context, 220), DensityUtil.dip2px(context, 180));
        canvas.drawArc(rectF, -10, -100, true, paint);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(rectF, -120, -60, false, paint);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(rectF, -200, -140, false, paint);
    }
}
