package com.mavenproject.rtproject;

import org.jfree.chart.JFreeChart;
import org.jfree.data.statistics.BoxAndWhiskerCategoryDataset;

public interface BoxPlotInterface {

    BoxAndWhiskerCategoryDataset createDataset();

    JFreeChart createChart(BoxAndWhiskerCategoryDataset boxAndWhiskerCategoryDataset);
}
