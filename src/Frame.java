import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.*;

public class Frame implements Runnable {
    private pPanel pane;
    private int[][] matrix;
    private int[] solutionRows;
    private int nrows;
    private int ncols;


    public Frame(int[][] matrix, int[] solutionRows, int nrows, int ncols) {
        this.matrix = matrix;
        this.solutionRows = solutionRows;
        this.nrows = nrows;
        this.ncols = ncols;
    }

    public void run() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            System.out.println(ex.getMessage());
        }

        JFrame frame = new JFrame("Pavage Solution - INF441");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        pane = new pPanel(nrows, ncols);

        //paint each element of the table with a random color
        for (int i = 0; i < solutionRows.length; i++) {
            Color color = new Color((int)(Math.random() * 0x1000000));            
            for (int j = 0; j < nrows*ncols; j++) {
                if (matrix[solutionRows[i]][j] == 1) {
                    int x = j/ncols;
                    int y = j%ncols;

                    pane.setCellColor(x, y, color);
                }
            }
        }
        frame.add(pane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}