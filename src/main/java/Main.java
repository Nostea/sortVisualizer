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
        frame.setBounds(100, 100, 800, 400);

        TestPanel panel = new TestPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setVisible(true);


    }
}
