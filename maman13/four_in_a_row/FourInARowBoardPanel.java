package maman13.four_in_a_row;

import javax.swing.*;
import java.awt.*;

public class FourInARowBoardPanel extends JPanel {
    int width, height;

    int rows;

    int cols;

    FourInARowBoardPanel() {
        rows = Constants.NUM_OF_ROWS;
        cols = Constants.NUM_OF_COLS;
        setSize(width = cols * Constants.CELL_HEIGHT_PIXELS, height = rows * Constants.CELL_HEIGHT_PIXELS);
        setVisible(true);
    }

    public void paint(Graphics g) {
        width = getSize().width;
        height = getSize().height;

        System.out.println("width=" + width + " height=" + height);

        // draw the rows
        int rowHt = height / (rows);
        int i;
        for (i = 0; i < rows; i++)
            g.drawLine(0, i * rowHt, width, i * rowHt);

        // draw the columns
        int rowWid = width / (cols);
        for (i = 0; i < cols; i++)
            g.drawLine(i * rowWid, 0, i * rowWid, height);
    }
}
