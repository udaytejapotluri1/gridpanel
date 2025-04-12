import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainPanel extends JPanel implements ActionListener {
    String[] imageStringNameA = { "pat1.gif", "pat2.gif", "pat3.gif", "pat4.gif", "pat5.gif" };

    final static Image[] imageA = new Image[5];

    TileGridPanel tileGridPanelPtr = new TileGridPanel();

    JButton[] patchButtons = new JButton[5];
    JButton resetButton;

    public MainPanel() {
        try {
            for (int i = 0; i < 5; i++) {
                imageA[i] = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource(imageStringNameA[i]));
            }

            this.setLayout(new BorderLayout());

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10)); 
            buttonPanel.setBackground(new Color(255, 200, 0));

            for (int i = 0; i < patchButtons.length; i++) {
                patchButtons[i] = new JButton(new ImageIcon(imageA[i]));
                buttonPanel.add(patchButtons[i]);
                patchButtons[i].addActionListener(this);
            }

            this.add(buttonPanel, BorderLayout.NORTH);

            resetButton = new JButton("Reset");
            resetButton.addActionListener(this);
            JPanel resetPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            resetPanel.add(resetButton);
            resetPanel.setBackground(Color.PINK);
            this.add(resetPanel, BorderLayout.SOUTH);

            add(tileGridPanelPtr, BorderLayout.CENTER);
            tileGridPanelPtr.resetGridTile();
        } catch (Exception e) {
            System.err.println("An error occurred while initializing the MainPanel:");
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < patchButtons.length; i++) {
            if (e.getSource() == patchButtons[i]) {
                tileGridPanelPtr.selectedTile = i;
            }
        }

        if (e.getSource() == resetButton) {
            tileGridPanelPtr.resetGridTile();
        }
    }
}
