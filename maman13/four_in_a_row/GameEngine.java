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

    public Position getLowestAvailableCellAtColumn(int c) {
        for (int r = m_matrix.length - 1; r>=0; r--) {
            if (getColorAtCell(r, c) == CellColor.EMPTY) {
                return new Position(r, c);
            }
        }
        return null;
    }

    public void playTurn(int row, int col) {
        Position pos = getLowestAvailableCellAtColumn(col);
        if (pos == null) return;
        if (m_isBluePlayerTurn) {
            setColorAtCell(pos.getRow(), pos.getCol(), CellColor.BLUE);
            m_isBluePlayerTurn = false;
        }
        else {
            setColorAtCell(pos.getRow(), pos.getCol(), CellColor.RED);
            m_isBluePlayerTurn = true;
        }
    }

    private boolean checkIfRowContainsSequence(Position lastMove) {
        int posRow = lastMove.getRow();
        int posCol = lastMove.getCol();
        int maxSequenceLength = 0;
        int currentSequencLenght = 0;
        CellColor color = m_matrix[posRow][posCol];
        for (int c=0; c<m_matrix[posRow].length; c++) {
            if (m_matrix[posRow][c] == color) {
                currentSequencLenght++;
                if (currentSequencLenght >= 4) {
                    return true;
                }
            }
            else {
                currentSequencLenght = 0;
            }
        }
        return false;
    }

    private CellColor getColor(Position position) {
        return m_matrix[position.getRow()][position.getCol()];
    }

    public GameResult checkIfGameHasFinished(Position lastMove) {
        CellColor color = getColor(lastMove);
        boolean isVictory = false;
        if (checkIfRowContainsSequence(lastMove)) {
            isVictory = true;
        }
        if (isVictory) {
            if (color == CellColor.BLUE) {
                return GameResult.BLUE_HAS_WON;
            }
            else {
                return GameResult.RED_HAS_WON;
            }
        }
        return GameResult.NO_WINNER_YET;
    }
}
