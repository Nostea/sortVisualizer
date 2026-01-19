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

        TestPanel panel = new TestPanel(1300);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
        panel.startSorting();


    }
}
