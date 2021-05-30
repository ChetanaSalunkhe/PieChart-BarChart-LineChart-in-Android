package com.chetana.piechart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.DefaultAxisValueFormatter;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Context parent;
    PieChart piechart;
    BarChart barchart;
    LineChart linechart;

    PieData pieData;
    PieDataSet pieDataSet;

    BarData barData;
    BarDataSet barDataSet;

    LineData lineData;
    LineDataSet lineDataSet;

    float rainfall[] = {95f, 92f, 120f, 45f, 79f, 29f, 48f, 110f, 167f, 200f,89f,39f};
    String month[] = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sept","Oct","Nov","Dec"};
    float rainfall_[] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100,110,120};
    ArrayList<String> listMonth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        setUpPieChart();
        setUpBarChart();
        setUpLineChart();

        setListeners();

    }

    private void init(){
        parent = MainActivity.this;

        piechart = findViewById(R.id.piechart);
        barchart = findViewById(R.id.barchart);
        linechart = findViewById(R.id.linechart);

        listMonth = new ArrayList<String>();

        listMonth.clear();

        for(int i=0; i<month.length;i++){
            listMonth.add(month[i]);

        }

    }

    private void setListeners() {

    }

    private void setUpPieChart() {

        List<PieEntry> pieEntryList = new ArrayList<PieEntry>();
        for(int i=0; i<rainfall.length;i++){
            pieEntryList.add(new PieEntry(rainfall[i],month[i]));
        }

        pieDataSet = new PieDataSet(pieEntryList,"Rainfall in India");
        pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        pieData = new PieData(pieDataSet);

        //set data to piechart
        piechart.setData(pieData);
        piechart.animateY(1000);
        piechart.setEntryLabelTextSize(10);
        piechart.setCenterText("Rainfall in India");
        piechart.invalidate();
    }

    private void setUpBarChart() {

        List<BarEntry> barEntries = new ArrayList<BarEntry>();
        for(int i=0; i<rainfall.length;i++){
            barEntries.add(new BarEntry(rainfall_[i], rainfall[i]));
        }

        barDataSet = new BarDataSet(barEntries,"Rainfall in India");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barData = new BarData(barDataSet);
        barData.setBarWidth(4f);

        barchart.setData(barData);
        barchart.animateX(1000);
        barchart.getXAxis().setEnabled(true);
        barchart.setFitBars(true);
        barchart.invalidate();

        XAxis xAxis = barchart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(new DayAxisValueFormatter(listMonth));
        xAxis.setGranularity(1);
      // barchart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(listMonth));

    }

    private void setUpLineChart() {

        List<Entry> lineEntries = new ArrayList<Entry>();
        for(int i=0; i<rainfall.length;i++){
            lineEntries.add(new Entry(rainfall_[i], rainfall[i]));
        }

        lineDataSet = new LineDataSet(lineEntries,"Rainfall in India");
        lineDataSet.setColors(ColorTemplate.MATERIAL_COLORS);

        lineData = new LineData(lineDataSet);
        linechart.setData(lineData);
        linechart.animateX(1000);
        linechart.getXAxis().setEnabled(true);
        //linechart.setFitBars(true);
        linechart.invalidate();

        /*XAxis xAxis = linechart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(new DayAxisValueFormatter(listMonth));
        xAxis.setGranularity(1);*/
        // barchart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(listMonth));

    }

}
