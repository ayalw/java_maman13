package maman13.four_in_a_row;

/**
 * Data structure for a position on the board.
 */
public class Position {
    private int m_row;
    private int m_col;

    public Position(int row, int col) {
        m_row = row;
        m_col = col;
    }

    public int getRow() {
        return m_row;
    }

    public int getCol() {
        return m_col;
    }
}
