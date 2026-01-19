public class PaintingUtility {
    public PaintingUtility(){
    }

    public static void repaintPanel(TestPanel panel) {
        panel.repaint();

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
