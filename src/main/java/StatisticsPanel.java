import javax.swing.*;
import java.awt.*;

public class StatisticsPanel extends JPanel {
    private JLabel timeLabel;
    private JLabel algorithmLabel;
    private JLabel dataArrayLengthLabel;
    private JLabel dataArrayLengthNumberLabel;

    public StatisticsPanel(){
        setLayout(new GridLayout(3, 1, 5, 5));
        //setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        dataArrayLengthLabel = new JLabel("List Length: ");
        algorithmLabel = new JLabel("Algorithm: ");
        timeLabel = new JLabel("time (ms)");
        dataArrayLengthNumberLabel = new JLabel("length");

        add(dataArrayLengthLabel);
        add(dataArrayLengthNumberLabel);
        add(algorithmLabel);
        add(timeLabel);
    }

    public void displayListLength(int listLength) {
        String listLengthString = "" + listLength;
        dataArrayLengthNumberLabel.setText(listLengthString);
    }

    public void displayTime(String algorithm, long timeMs) {
        algorithmLabel.setText("Algorithm: " + algorithm);
        timeLabel.setText("Elapsed time: " + timeMs + " ms");
    }
}