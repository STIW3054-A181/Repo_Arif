package com.mavenproject.rtproject;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.util.ArrayList;


public class Normalization implements NormalizationInterface {

    @Override
    public void normalizeData(ArrayList<Double> data, ArrayList<String> fileNames) {

        DefaultCategoryDataset dcd = new DefaultCategoryDataset();

        for (int i = 0; i < data.size(); i++) {
            dcd.setValue(data.get(i), "Z-Score", fileNames.get(i));
        }

        JFreeChart jChart = ChartFactory.createLineChart("Z-Score Data", "PDF File", "Z-Score", dcd, PlotOrientation.VERTICAL, true, true, false);

        CategoryPlot plot = jChart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.BLACK);

        ChartFrame chartFrame = new ChartFrame("Normalization Graph", jChart, true);
        chartFrame.setSize(730, 500);
        chartFrame.setVisible(true);
        chartFrame.setLocationRelativeTo(null);
    }

}
