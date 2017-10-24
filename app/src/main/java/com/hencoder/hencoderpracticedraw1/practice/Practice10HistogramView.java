package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.model.Data;

import java.util.ArrayList;
import java.util.List;

public class Practice10HistogramView extends View {
    private static final String NAME = "直方图";
    private Paint paint;
    private float maxHeight;
    private float startX = 0f;
    private float width;
    private float space;

    private List<Data> mDataList;

    public Practice10HistogramView(Context context) {
        super(context);
        init();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        mDataList = new ArrayList<>();
        Data data = new Data("Froyo", 10.0f, Color.GREEN);
        mDataList.add(data);
        data = new Data("ICS", 18.0f, Color.GREEN);
        mDataList.add(data);
        data = new Data("JB", 22.0f, Color.GREEN);
        mDataList.add(data);
        data = new Data("KK", 27.0f, Color.GREEN);
        mDataList.add(data);
        data = new Data("L", 40.0f, Color.GREEN);
        mDataList.add(data);
        data = new Data("M", 60.0f, Color.GREEN);
        mDataList.add(data);
        data = new Data("N", 33.5f, Color.GREEN);
        mDataList.add(data);

        for (Data item : mDataList) {
            maxHeight = Math.max(maxHeight, item.getNumber());
        }

        paint = new Paint();
        paint.setStrokeWidth(2);
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.WHITE);
        paint.setTextSize(50);
        canvas.drawText(NAME, (canvas.getWidth() - paint.measureText(NAME)) / 2, canvas.getHeight() * 0.9f, paint);

        canvas.translate(canvas.getWidth() * 0.1f, canvas.getHeight() * 0.7f);//移动原点

        paint.setStyle(Paint.Style.STROKE);
        canvas.drawLine(0, 0, 0, -canvas.getHeight() * 0.6f, paint);//绘制y轴
        canvas.drawLine(0, 0, canvas.getWidth() * 0.8f, 0, paint);//绘制x轴

        width = (float) ((canvas.getWidth() * 0.8 - 100) / mDataList.size() * 0.8f);
        space = (float) ((canvas.getWidth() * 0.8 - 100) / mDataList.size() * 0.2f);

        startX = 0f;//这句很重要
        paint.setTextSize(36);
        paint.setStyle(Paint.Style.FILL);
        for (Data data : mDataList) {
            paint.setColor(Color.WHITE);
            canvas.drawText(data.getName(), startX + space + (width - paint.measureText(data.getName())) / 2, 30, paint);

            paint.setColor(data.getColor());
            canvas.drawRect(startX + space, -data.getNumber() / maxHeight * canvas.getHeight() * 0.5f, startX + space + width, 0, paint);
            startX += space + width;
        }
    }
}
