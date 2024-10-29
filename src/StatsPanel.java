import javax.swing.*;
import java.awt.*;
import java.util.List;

public class StatsPanel extends JPanel {
    private JLabel mean;
    private JLabel max;
    private JLabel min;
    private JLabel standardDeviation;

    private double calculateMean(List<Double> data) {
        double sum = 0.0;
        for (double x : data) {
            sum += x;
        }
        return sum / data.size();
    }

    private double findMax(List<Double> data) {
        double max = Double.NEGATIVE_INFINITY;
        for (double x : data) {
            if (x > max) {
                max = x;
            }
        }
        return max;
    }

    private double findMin(List<Double> data) {
        double min = Double.POSITIVE_INFINITY;
        for (double x : data) {
            if (x < min) {
                min = x;
            }
        }
        return min;
    }

    private double calculateStandardDeviation(List<Double> data, double mean) {
        double sum = 0.0;
        for (double x : data) {
            sum += Math.pow(x - mean, 2);

        }
        return Math.sqrt(sum / (data.size() - 1));
    }

    public StatsPanel(List<Double> data) {
        setLayout(new GridLayout(4,1,5,5));

        double mean = calculateMean(data);
        double max = findMax(data);
        double min = findMin(data);
        double standardDeviation = calculateStandardDeviation(data,mean);

        mean = new JLabel("Mean: " + mean);
        max = new JLabel("Max: " + max);
        min = new JLabel("Min: " + min);
        standardDeviation = new JLabel("Standard Deviation: " + standardDeviation);

        add(mean);
        add(max);
        add(min);
        add(standardDeviation);
    }


}