public class PaintingUtility {
    public PaintingUtility(){
    }

    public static void repaintPanel(GraphPanel panel) {
        panel.repaint();

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int getIndexPosition(int position) {
        return position;
    }
}
