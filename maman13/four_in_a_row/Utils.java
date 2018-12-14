package maman13.four_in_a_row;

/**
 * General Utility methods and calculation.
 */
public class Utils {
    /**
     * Get closest column based on clicked pixel.
     * @param xPos
     * @return
     */
    public static int getColFromXPosition(int xPos) {
        return (xPos / Constants.CELL_WIDTH_PIXELS);
    }

    /**
     * Get closest row based on clicked pixel.
     * @param yPos
     * @return
     */
    public static int getRowFromYPosition(int yPos) {
        return (yPos / Constants.CELL_HEIGHT_PIXELS);
    }
}
