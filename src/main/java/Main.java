import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {
    private static final int MAX_PANELS = 4;

    private static ArrayList<UIPanel> uiPanels = new ArrayList<>();
    private static ArrayList<JPanel> existingGraphs =  new ArrayList<>();
    private static JPanel centerPanel;
    private static JButton addPanelButton; //
    private static JButton removePanelButton;

    public static void main(String[] args) {
        FlatDarkLaf.setup();

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Sorting algorithms visualizer");
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setBounds(100, 100, 1400, 600);

        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(1, 0, 10, 10));
        frame.getContentPane().add(centerPanel, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));

        addPanelButton = new JButton("Add Graph Panel");
        JButton startAllButton = new JButton("Start All");
        removePanelButton = new JButton("Remove last graph");

        if (uiPanels.size() == 1) {
            removePanelButton.setEnabled(false);
            return;
        }

        addPanelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewGraphPanel();
                updateButtonStates();
            }
        });

        removePanelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeLastPanel();
                updateButtonStates();
            }
        });

        startAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startAllSorting();
            }
        });

        controlPanel.add(addPanelButton);
        controlPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        controlPanel.add(removePanelButton);
        controlPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        controlPanel.add(startAllButton);

        frame.getContentPane().add(controlPanel, BorderLayout.LINE_END);

        addNewGraphPanel(); // one Graph must be there by default
        updateButtonStates();

        frame.setVisible(true);
    }

    private static void addNewGraphPanel() {

        if (uiPanels.size() >= MAX_PANELS) {
            JOptionPane.showMessageDialog(null,
                    "Maximum " + MAX_PANELS + " Graphs allowed.",
                    "Limit reached",
                    JOptionPane.WARNING_MESSAGE);
            addPanelButton.setEnabled(false);
            return; //
        }

        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BorderLayout());
        containerPanel.setBorder(BorderFactory.createTitledBorder("Graph " + (uiPanels.size() + 1)));

        StatisticsPanel statisticsPanel = new StatisticsPanel();
        GraphPanel graphPanel = new GraphPanel(NumberGenerator.DATA_ARRAY_LENGTH, statisticsPanel);
        UIPanel uiPanel = new UIPanel(graphPanel);

        containerPanel.add(statisticsPanel, BorderLayout.NORTH);
        containerPanel.add(graphPanel, BorderLayout.CENTER);
        containerPanel.add(uiPanel, BorderLayout.SOUTH);

        centerPanel.add(containerPanel);
        uiPanels.add(uiPanel);
        existingGraphs.add(containerPanel);

        if (uiPanels.size() >= MAX_PANELS) {
            addPanelButton.setEnabled(false);
            addPanelButton.setText("Max number of panels reached");
        }

        centerPanel.revalidate();
        centerPanel.repaint();
    }

    private static void startAllSorting() {
        for (UIPanel uiPanel : uiPanels) {
            uiPanel.startSorting();
        }
    }

    private static void removeLastPanel() {
        if (uiPanels.isEmpty()) {
            return;
        }

        int lastIndex = uiPanels.size() - 1;

        uiPanels.remove(lastIndex);
        JPanel containerToRemove = existingGraphs.remove(lastIndex);

        centerPanel.remove(containerToRemove);
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    private static void updateButtonStates() {

        if (uiPanels.size() >= MAX_PANELS) {
            addPanelButton.setEnabled(false);
        } else {
            addPanelButton.setEnabled(true);
            addPanelButton.setText("Add graph panel");
        }


        if (uiPanels.size() <= 1) {
            removePanelButton.setEnabled(false);
        } else {
            removePanelButton.setEnabled(true);
            removePanelButton.setText("Remove last graph");
        }
    }

}
