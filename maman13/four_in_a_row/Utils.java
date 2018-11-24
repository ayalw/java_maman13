package maman13.four_in_a_row;

public class Utils {
    public static int getColFromXPosition(int xPos) {
        return (xPos / Constants.CELL_WIDTH_PIXELS);
    }

    public static int getRowFromYPosition(int yPos) {
        return (yPos / Constants.CELL_HEIGHT_PIXELS);
    }
}
