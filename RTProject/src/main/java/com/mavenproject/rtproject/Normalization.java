/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavenproject.rtproject;

import java.awt.Color;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Gifhary
 */
public class Normalization {

    public static void normalizeData(Map<String, Integer> data, String fileNames) {

        DefaultCategoryDataset dcd = new DefaultCategoryDataset();
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            dcd.setValue(entry.getValue(), "Frequency", entry.getKey());
        }

        JFreeChart jChart = ChartFactory.createBarChart("Character Frequency", "Character", "Frequency", dcd, PlotOrientation.VERTICAL, true, true, false);

        CategoryPlot plot = jChart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.BLACK);

        ChartFrame chartFrame = new ChartFrame("File name : " + fileNames, jChart, true);
        chartFrame.setSize(730, 470);
        chartFrame.setVisible(true);
    }

}
