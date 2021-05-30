package com.chetana.piechart;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;
import java.util.List;

public class DayAxisValueFormatter implements IAxisValueFormatter {

    String month[] = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sept","Oct","Nov","Dec"};
    List<String> labels;

    private BarLineChartBase<?> chart;

    public DayAxisValueFormatter(ArrayList<String> chart) {
        this.labels = chart;
    }

    public DayAxisValueFormatter(List<String> labels) {
        this.labels = labels;
    }

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        try {
            int index = (int) value;
            return month[index];
        } catch (Exception e) {
            return "";
        }
    }
}
