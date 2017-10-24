package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.DensityUtil;

public class Practice6DrawLineView extends View {
    private Paint paint;
    private Context context;

    public Practice6DrawLineView(Context context) {
        this(context, null);
    }

    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        this.paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(15);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //        练习内容：使用 canvas.drawLine() 方法画直线
        canvas.drawLine(DensityUtil.dip2px(context, 100), DensityUtil.dip2px(context, 100),
                DensityUtil.dip2px(context, 200), DensityUtil.dip2px(context, 200), paint);
    }
}
