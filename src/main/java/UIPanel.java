import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class UIPanel extends JPanel implements ActionListener {
    String[] algorithmOptions;
    JComboBox<String> comboBox;
    GraphPanel graphPanel;

    public UIPanel(GraphPanel graphPanel){
        this.graphPanel = graphPanel;
        algorithmOptions = new String[]{"Quicksort", "Insertionsort", "Bubblesort", "Selectionsort"};
        Arrays.sort(algorithmOptions);
        comboBox = new JComboBox<>(algorithmOptions);
        comboBox.setSelectedIndex(0);
        comboBox.addActionListener(this);

        add(comboBox);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        String algorithmSelected = (String)cb.getSelectedItem();

        graphPanel.startSorting(algorithmSelected);
    }
}
