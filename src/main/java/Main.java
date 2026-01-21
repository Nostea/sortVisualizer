import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        FlatDarkLaf.setup();
        System.out.println("This is a sorting algorithm visualizer");

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Sorting algorithms visualizer");
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setBounds(100, 100, 1400, 600);

        GraphPanel panel = new GraphPanel(1250);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        //panel.startSorting();

        UIPanel uiPanel = new UIPanel(panel);
        frame.getContentPane().add(uiPanel, BorderLayout.LINE_END);

        frame.setVisible(true);

        //Rekursion example = new Rekursion();
        //example.sayHello();

    }
}
