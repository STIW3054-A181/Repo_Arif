package com.mavenproject.rtproject;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BoxAndWhiskerRenderer;
import org.jfree.data.statistics.BoxAndWhiskerCategoryDataset;
import org.jfree.data.statistics.DefaultBoxAndWhiskerCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import java.awt.*;
import java.util.ArrayList;


public class BoxPlot extends ApplicationFrame implements BoxPlotInterface {

    private final ArrayList<Double> stDeviations;

    public BoxPlot(final String tittle, ArrayList<Double> stDeviations) {
        super(tittle);
        this.stDeviations = stDeviations;

        final BoxAndWhiskerCategoryDataset dataset = createDataset();
        final CategoryAxis xAxis = new CategoryAxis("");
        final NumberAxis yAxis = new NumberAxis("Sd Value");
        yAxis.setAutoRangeIncludesZero(false);
        final BoxAndWhiskerRenderer renderer = new BoxAndWhiskerRenderer();
        BoxAndWhiskerCategoryDataset boxandwhiskercategorydataset = createDataset();
        JFreeChart jfreechart = createChart(boxandwhiskercategorydataset);

        final CategoryPlot plot = new CategoryPlot(dataset, xAxis, yAxis, renderer);
        final JFreeChart jFreeChart = new JFreeChart(
                "Box-and-Whisker ",
                new Font("SansSerif", Font.BOLD, 14),
                plot,
                true
        );
        final ChartPanel chartpanel = new ChartPanel(jFreeChart, false);
        chartpanel.setPreferredSize(new Dimension(730, 470));
        setContentPane(chartpanel);
    }

    @Override
    public BoxAndWhiskerCategoryDataset createDataset() {

        DefaultBoxAndWhiskerCategoryDataset defaultboxandwhiskercategorydataset = new DefaultBoxAndWhiskerCategoryDataset();
        defaultboxandwhiskercategorydataset.add(stDeviations, "Standard Deviation", "PDF File ");

        return defaultboxandwhiskercategorydataset;
    }

    @Override
    public JFreeChart createChart(BoxAndWhiskerCategoryDataset boxandwhiskercategorydataset) {
        CategoryAxis categoryaxis = new CategoryAxis(null);
        NumberAxis numberaxis = new NumberAxis("Value of Standard Deviation");
        BoxAndWhiskerRenderer renderer = new BoxAndWhiskerRenderer();
        renderer.setSeriesOutlinePaint(0, Color.BLACK);
        CategoryPlot categoryplot = new CategoryPlot(boxandwhiskercategorydataset, categoryaxis, numberaxis, renderer);
        JFreeChart jfreechart = new JFreeChart("Box Plot Whisker", categoryplot);
        jfreechart.setBackgroundPaint(Color.white);
        categoryplot.setBackgroundPaint(Color.lightGray);
        categoryplot.setDomainGridlinePaint(Color.white);
        categoryplot.setDomainGridlinesVisible(true);
        categoryplot.setRangeGridlinePaint(Color.white);
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        return jfreechart;
    }

}
