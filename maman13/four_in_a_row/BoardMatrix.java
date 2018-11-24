package maman13.four_in_a_row;

public class BoardMatrix {

    private CellColor[][] m_matrix;

    public BoardMatrix() {
        m_matrix = new CellColor[Constants.NUM_OF_ROWS][Constants.NUM_OF_COLS];
        clear();
    }

    public void clear() {
        for (int r=0; r < m_matrix.length; r++) {
            for (int c=0; c<m_matrix[r].length; c++) {
                m_matrix[r][c] = CellColor.EMPTY;
            }
        }
    }

    public CellColor getColorAtCell(int row, int col) {
        if (row > m_matrix.length) return CellColor.EMPTY;
        if (col > m_matrix[row].length) return CellColor.EMPTY;
        return m_matrix[row][col];
    }
}
