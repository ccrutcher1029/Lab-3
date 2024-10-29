import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class TablePanel {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                createAndShowTable("fe3615aa-af71-46cb-8cac-395a5588be9e_Data.csv");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
public static void createAndShowTable(String path) throws IOException {
    JFrame frame = new JFrame("Birth Rate");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 400);

    Vector<String> colomnNames = new Vector<>();
    Vector<String> colomnValues = new Vector<>();
    List<Double> numericData = new ArrayList<>();
    BufferedReader br = new BufferedReader(new FileReader(path));
    String line;

    String[] headers = br.readLine().split(",");
    for(String header : headers) {
        colomnNames.add(header);
    }

    while((line = br.readLine()) != null) {
        String[] rowValues = line.split(",");
        Vector<String> row = new Vector<>();
        for(String value : rowValues) {
            row.add(value);
        }
        colomnValues.add(row);
    }
    br.close();

    JTable table = new JTable(new DefaultTableModel());
    JScrollPane scrollPane = new JScrollPane(table);
    frame.add(scrollPane, BorderLayout.NORTH);

    ChartPanel lineChartPanel;


    frame.setVisible(true);
}
}
