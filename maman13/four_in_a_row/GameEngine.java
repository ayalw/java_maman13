package maman13.four_in_a_row;

/**
 * This class holds the non-UI logic of the game.
 */
public class GameEngine {

    /**
     * This represents the logical board.
     */
    private CellColor[][] m_matrix;

    /**
     * Flag to denote who's turn it is - blue or red.
     */
    private boolean m_isBluePlayerTurn = true;

    /**
     * Constructor
     */
    public GameEngine() {
        m_matrix = new CellColor[Constants.NUM_OF_ROWS][Constants.NUM_OF_COLS];
        clear();
    }

    /**
     * Clear board for a new game.
     */
    public void clear() {
        for (int r=0; r < m_matrix.length; r++) {
            for (int c=0; c<m_matrix[r].length; c++) {
                m_matrix[r][c] = CellColor.EMPTY;
            }
        }
        m_isBluePlayerTurn = true;
    }

    /**
     * Get whose disc (if any) is available at given row and column.
     * @param row
     * @param col
     * @return
     */
    public CellColor getColorAtCell(int row, int col) {
        if (row >= m_matrix.length) return CellColor.EMPTY;
        if (col >= m_matrix[row].length) return CellColor.EMPTY;
        return m_matrix[row][col];
    }

    /**
     * Place a disc in a specified location.
     * @param row
     * @param col
     * @param color
     */
    public void setColorAtCell(int row, int col, CellColor color) {
        if (row >= m_matrix.length) return;
        if (col >= m_matrix[row].length) return;
        m_matrix[row][col] = color;
    }

    /**
     * Getter for who's turn is it flag.
     * @return
     */
    public boolean isBluePlayerTurn() {
        return m_isBluePlayerTurn;
    }

    /**
     * Get the 'height' at a certain column.
     * So when a player is dropping a disc on this column, we know where to place the new disc.
     * (on top of the highest disc at that column).
     * @param c
     * @return
     */
    public Position getLowestAvailableCellAtColumn(int c) {
        for (int r = m_matrix.length - 1; r>=0; r--) {
            if (getColorAtCell(r, c) == CellColor.EMPTY) {
                return new Position(r, c);
            }
        }
        return null;
    }

    /**
     * Evaluate consequence of a player action, which is choosing a column to drop his disc on.
     * @param row
     * @param col
     */
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

    /**
     * Check if the last disc dropped is touching 3 additional same-color discs in same row.
     * @param lastMove
     * @return
     */
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

    /**
     * Check if the last disc dropped is touching 3 additional same-color discs in same column.
     * @param lastMove
     * @return
     */
    private boolean checkIfColContainsSequence(Position lastMove) {
        int posRow = lastMove.getRow();
        int posCol = lastMove.getCol();
        int currentSequencLenght = 0;
        CellColor color = m_matrix[posRow][posCol];
        for (int r=0; r<m_matrix.length; r++) {
            if (m_matrix[r][posCol] == color) {
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

    /**
     * Find the start point of the diagonal '/' on which the last disc has been dropped.
     * @param lastMove
     * @return
     */
    private Position getAscendingDiagonalStartPosition(Position pos) {
        int r = pos.getRow();
        int c = pos.getCol();
        while (r < m_matrix.length - 1 && c > 0) {
            r++;
            c--;
        }
        return new Position(r,c);
    }

    /**
     * Find the start point of the diagonal '\' on which the last disc has been dropped.
     * @param lastMove
     * @return
     */
    private Position getDescendingDiagonalStartPosition(Position pos) {
        int r = pos.getRow();
        int c = pos.getCol();
        while (r < m_matrix.length - 1 && c < m_matrix[r].length - 1) {
            r++;
            c++;
        }
        return new Position(r,c);
    }

    /**
     * Check if the last disc dropped is touching 3 additional same-color discs in same ascending diagonal.
     * @param lastMove
     * @return
     */
    private boolean checkIfAscendingDiagonalContainsSequence(Position lastMove) {
        int posRow = lastMove.getRow();
        int posCol = lastMove.getCol();
        int currentSequencLenght = 0;
        CellColor color = m_matrix[posRow][posCol];

        Position startPos = getAscendingDiagonalStartPosition(lastMove);
        int r = startPos.getRow();
        int c = startPos.getCol();
        while (r >=0 && c < m_matrix[r].length - 1) {
            if (m_matrix[r][c] == color) {
                currentSequencLenght++;
                if (currentSequencLenght >= 4) {
                    return true;
                }
            }
            else {
                currentSequencLenght = 0;
            }
            r--;
            c++;
        }
        return false;
    }

    /**
     * Check if the last disc dropped is touching 3 additional same-color discs in same descending diagonal.
     * @param lastMove
     * @return
     */
    private boolean checkIfDescendingDiagonalContainsSequence(Position lastMove) {
        int posRow = lastMove.getRow();
        int posCol = lastMove.getCol();
        int currentSequencLenght = 0;
        CellColor color = m_matrix[posRow][posCol];

        Position startPos = getDescendingDiagonalStartPosition(lastMove);
        int r = startPos.getRow();
        int c = startPos.getCol();
        while (r >=0 && c >= 0) {
            if (m_matrix[r][c] == color) {
                currentSequencLenght++;
                if (currentSequencLenght >= 4) {
                    return true;
                }
            }
            else {
                currentSequencLenght = 0;
            }
            r--;
            c--;
        }
        return false;
    }

    /**
     * Get color at position.
     * @param position
     * @return
     */
    private CellColor getColor(Position position) {
        return m_matrix[position.getRow()][position.getCol()];
    }

    /**
     * Check if we have a winner after the last move that occurred.
     * @param lastMove
     * @return
     */
    public GameResult checkIfGameHasFinished(Position lastMove) {
        CellColor color = getColor(lastMove);
        boolean isVictory = false;
        if (checkIfRowContainsSequence(lastMove)
        || checkIfColContainsSequence(lastMove)
        || checkIfAscendingDiagonalContainsSequence(lastMove)
        || checkIfDescendingDiagonalContainsSequence(lastMove)) {
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

    /**
     * Check if column has reached its maximal height and no user can drop discs on it.
     * @param col
     * @return
     */
    public boolean isColumnFull(int col) {
        return m_matrix[0][col] != CellColor.EMPTY;
    }
}
