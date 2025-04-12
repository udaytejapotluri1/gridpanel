import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class TileGridPanel extends JPanel {
    int selectedTile = -1;
    static final int squareSide = 25;
    int gridRows = 5, gridCols = 5;

    Image[][] gif2dArray = new Image[gridRows][gridCols];

    public TileGridPanel() {
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent event) {
                fillGrid();
                repaint();
            }
        });
        this.setBackground(Color.yellow);
    }

    
    public void fillGrid() {
        if (selectedTile >= 0) {
            for (int row = 0; row < gridRows; row++) {
                for (int col = 0; col < gridCols; col++) {
                    gif2dArray[row][col] = MainPanel.imageA[selectedTile];
                }
            }
        }
    }

    public void resetGridTile() {
        for (int row = 0; row < gridRows; row++) {
            for (int col = 0; col < gridCols; col++) {
                gif2dArray[row][col] = null;
            }
        }
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int gridWidth = gridCols * squareSide;
        int gridHeight = gridRows * squareSide;
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        int startX = (panelWidth - gridWidth) / 2;
        int startY = (panelHeight - gridHeight) / 2;

        for (int row = 0; row < gridRows; row++) {
            for (int col = 0; col < gridCols; col++) {
                if (gif2dArray[row][col] != null) {
                    try {
                        g.drawImage(gif2dArray[row][col], startX + (squareSide * col), startY + (squareSide * row), this);
                    } catch (Exception e) {
                        System.err.println("An error occurred while drawing an image on TileGridPanel:");
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
