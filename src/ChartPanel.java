import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ChartPanel extends JPanel {

    public ChartPanel(List<Double> data) {
        DefaultCategoryDataset dataset = createDataset(data);
        JFreeChart lineChart = ChartFactory.createDataset(data);

        JFreeChart lineChart = ChartFactory.createLineChart("Stats Line Chart", "Mean  Max  Min  Standard Deviation", "Value", dataset, PlotOrientation.VERTICAL,
        true, true, false);

        ChartPanel chartPanel = new ChartPanel(lineChart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        this.add(chartPanel);
    }

    private DefaultCategoryDataset createDataset(List<Double> data){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int i = 0; i < data.size(); i++){
            dataset.addValue(data.get(i), Integer.toString(i + 1));
        }
        return dataset;
    }
}