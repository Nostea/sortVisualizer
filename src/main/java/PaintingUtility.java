public class PaintingUtility {

    public static void repaintPanel(GraphPanel panel) {
        panel.repaint();

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
