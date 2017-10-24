package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.model.Data;

import java.util.ArrayList;
import java.util.List;

public class Practice11PieChartView extends View {
    private static final String NAME = "饼图";

    private float radius = 300;
    private List<Data> mDataList;
    private Paint paint;
    private RectF rectF;

    private float total;
    private float max;

    float startAngle; // 开始的角度
    float sweptAngle;      // 扫过的角度
    float halfAngle;       // 当前扇形一半的角度

    float lineStartX = 0f; // 直线开始的X坐标
    float lineStartY = 0f; // 直线开始的Y坐标
    float lineEndX;        // 直线结束的X坐标
    float lineEndY;        // 直线结束的Y坐标

    public Practice11PieChartView(Context context) {
        super(context);
        init();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mDataList = new ArrayList<>();
        Data data = new Data("Gingerbread", 15.0f, Color.WHITE);
        mDataList.add(data);
        data = new Data("Ice Cream Sandwich", 20.0f, Color.MAGENTA);
        mDataList.add(data);
        data = new Data("Jelly Bean", 22.0f, Color.GRAY);
        mDataList.add(data);
        data = new Data("KitKat", 28.0f, Color.GREEN);
        mDataList.add(data);
        data = new Data("Lollipop", 30.0f, Color.BLUE);
        mDataList.add(data);
        data = new Data("Marshmallow", 70.0f, Color.RED);
        mDataList.add(data);
        data = new Data("Nougat", 50.5f, Color.YELLOW);
        mDataList.add(data);

        max = Float.MIN_VALUE;
        total = 0;
        for (Data data1 : mDataList) {
            total += data1.getNumber();
            max = Math.max(max, data1.getNumber());
        }

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setTextSize(50);
        paint.setColor(Color.WHITE);
        canvas.drawText(NAME, canvas.getWidth() / 2 - 100 - paint.measureText(NAME) / 2, (float) (canvas.getHeight() * 0.9), paint);

        canvas.translate(canvas.getWidth() / 2 - 100, canvas.getHeight() / 2 - 100); //将canvas的原点x轴移动canvas.getWidth() / 2 - 100 y轴移动canvas.getHeight() / 2 - 100
        rectF = new RectF(-300, -300, 300, 300);

        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(30);
        startAngle = 0f; //这句代码很重要，不然有bug

        for (Data data : mDataList) {
            paint.setColor(data.getColor());
            sweptAngle = data.getNumber() / total * 360f;
            halfAngle = startAngle + sweptAngle / 2;

            //角度=弧度*180/Math.PI
            lineStartX = radius * (float) Math.cos(halfAngle / 180 * Math.PI);//圆弧中点的X坐标
            lineStartY = radius * (float) Math.sin(halfAngle / 180 * Math.PI);//圆弧中点的Y坐标
            lineEndX = (radius + 50) * (float) Math.cos(halfAngle / 180 * Math.PI);
            lineEndY = (radius + 50) * (float) Math.sin(halfAngle / 180 * Math.PI);

            if (max == data.getNumber()) {
                canvas.save();//保存当前的状态
                canvas.translate(0.1f * lineStartX, lineStartY * 0.1f);  // 移动画布的原点
                canvas.drawArc(rectF, startAngle, sweptAngle, true, paint);
            } else {
                canvas.drawArc(rectF, startAngle, sweptAngle - 2f, true, paint);
            }

            paint.setColor(Color.WHITE);
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawLine(lineStartX, lineStartY, lineEndX, lineEndY, paint);
            if (halfAngle > 90 && halfAngle <= 270) {
                canvas.drawLine(lineEndX, lineEndY, lineEndX - 50, lineEndY, paint);
                paint.setStyle(Paint.Style.FILL);
                canvas.drawText(data.getName(), lineEndX - 50 - 10 - paint.measureText(data.getName()), lineEndY, paint);
            } else {
                canvas.drawLine(lineEndX, lineEndY, lineEndX + 50, lineEndY, paint);
                paint.setStyle(Paint.Style.FILL);
                canvas.drawText(data.getName(), lineEndX + 50 + 10, lineEndY, paint);
            }
            if (max == data.getNumber()) {
                canvas.restore();//恢复save之前的状态
            }
            startAngle += sweptAngle;
        }
    }
}
