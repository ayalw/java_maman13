package maman13.four_in_a_row;

import javafx.scene.control.Cell;

import javax.swing.*;
import java.awt.*;

public class FourInARowBoardPanel extends JPanel {
    int width, height;
    int rows;
    int cols;
    BoardMatrix matrix;

    FourInARowBoardPanel(BoardMatrix matrix) {
        this.matrix = matrix;
        rows = Constants.NUM_OF_ROWS;
        cols = Constants.NUM_OF_COLS;
        setSize(width = cols * Constants.CELL_HEIGHT_PIXELS, height = rows * Constants.CELL_HEIGHT_PIXELS);
        setVisible(true);
    }

    public void paint(Graphics g) {
        drawGrid(g);
    }

    public Color getColorAtCell(int r, int c) {
        CellColor color = matrix.getColorAtCell(r, c);
        if (color == CellColor.BLUE) return Color.BLUE;
        if (color == CellColor.RED) return Color.RED;
        return Color.WHITE;
    }

    private void drawGrid(Graphics g) {
        for (int r=0; r<rows; r++) {
            for (int c=0; c<cols; c++) {
                drawCell(g, r, c);
                drawCircleInCell(g, r, c, getColorAtCell(r, c));
            }
        }
    }

    private void drawCell(Graphics g, int row, int col) {
        if (row > rows || col > cols) return;
        int positionX = Constants.CELL_WIDTH_PIXELS * col;//this.getSize().width / cols;
        int positionY = Constants.CELL_HEIGHT_PIXELS * row;//this.getSize().height / rows;
        System.out.println("x=" + positionX + " y="+positionY);
        g.setColor(Color.BLACK);
        g.drawRect(positionX, positionY, Constants.CELL_HEIGHT_PIXELS, Constants.CELL_HEIGHT_PIXELS);
    }

    public void drawCircleInCell(Graphics g, int row, int col, Color color) {
        if (row > rows || col > cols) return;
        int positionX = Constants.CELL_WIDTH_PIXELS * col;//this.getSize().width / cols;
        int positionY = Constants.CELL_HEIGHT_PIXELS * row;//this.getSize().height / rows;
        System.out.println("x=" + positionX + " y="+positionY);
        int circleDiameter = (int)(Constants.CELL_HEIGHT_PIXELS * Constants.CELL_TO_CIRCLE_RATIO);
        g.setColor(color);
        g.fillOval(positionX + Constants.DISTANCE_INSIDE_CELL_PIXELS,
                positionY + Constants.DISTANCE_INSIDE_CELL_PIXELS,
                circleDiameter, circleDiameter);

    }
}