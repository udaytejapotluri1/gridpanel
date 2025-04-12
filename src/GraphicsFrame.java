import javax.swing.*;
import java.awt.*;

public class GraphicsFrame extends JFrame {
    public static void main(String[] args) {
        try {
            GraphicsFrame frame = new GraphicsFrame();
            frame.setName("Frame");
            frame.setSize(600, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        } catch (Exception e) {
            System.err.println("An error occurred while initializing the GraphicsFrame:");
            e.printStackTrace();
        }
    }

    
    public GraphicsFrame() {
        super();
        MainPanel mainPanelPtr = new MainPanel();
        this.add(mainPanelPtr, BorderLayout.CENTER);
    }
}
