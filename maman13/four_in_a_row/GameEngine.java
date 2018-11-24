package maman13.four_in_a_row;

public class GameEngine {

    private CellColor[][] m_matrix;
    private boolean m_isBluePlayerTurn = true;

    public GameEngine() {
        m_matrix = new CellColor[Constants.NUM_OF_ROWS][Constants.NUM_OF_COLS];
        clear();
    }

    public void clear() {
        for (int r=0; r < m_matrix.length; r++) {
            for (int c=0; c<m_matrix[r].length; c++) {
                m_matrix[r][c] = CellColor.EMPTY;
            }
        }
        m_isBluePlayerTurn = true;
    }

    public CellColor getColorAtCell(int row, int col) {
        if (row >= m_matrix.length) return CellColor.EMPTY;
        if (col >= m_matrix[row].length) return CellColor.EMPTY;
        return m_matrix[row][col];
    }

    public void setColorAtCell(int row, int col, CellColor color) {
        if (row >= m_matrix.length) return;
        if (col >= m_matrix[row].length) return;
        m_matrix[row][col] = color;
    }

    public boolean isBluePlayerTurn() {
        return m_isBluePlayerTurn;
    }

    public void playTurn(int row, int col) {
        if (getColorAtCell(row, col) == CellColor.EMPTY) {
            if (m_isBluePlayerTurn) {
                setColorAtCell(row, col, CellColor.BLUE);
                m_isBluePlayerTurn = false;
            }
            else {
                setColorAtCell(row, col, CellColor.RED);
                m_isBluePlayerTurn = true;
            }
        }
    }
}
