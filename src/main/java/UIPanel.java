import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class UIPanel extends JPanel {
    String[] algorithmOptions;
    JComboBox<String> comboBox;
    GraphPanel graphPanel;
    private String selectedAlgorithm;

    public UIPanel(GraphPanel graphPanel){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.graphPanel = graphPanel;
        algorithmOptions = new String[]{"Quicksort", "Insertionsort", "Bubblesort", "Selectionsort"};
        Arrays.sort(algorithmOptions);

        comboBox = new JComboBox<>(algorithmOptions);
        comboBox.setSelectedIndex(0);
        selectedAlgorithm = (String)comboBox.getSelectedItem(); //preselect first algorithm, otherwise error if user doesn't pick an algorithm before starting the sort


        // ComboBox memorizes selected algorithm for actual execution by button later
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedAlgorithm = (String)comboBox.getSelectedItem();
            }
        });
        add(comboBox);
    }

    // used by Jbutton
    public void startSorting() {
        graphPanel.startSorting(selectedAlgorithm);
    }
}
