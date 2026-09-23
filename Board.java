import java.util.ArrayList;

public class Board {

    private int COLUMN;
    private int ROW;

    ArrayList<ArrayList<String>> board; // array 2d [10][10]

    Board() {
        this.COLUMN = 10;
        this.ROW = 10;
        createBoard();
    }

    Board(int column, int row) {
        this.COLUMN = column;
        this.ROW = row;
        createBoard();
    }

    private void createBoard() {
        board = new ArrayList<>();
        for (int row = 0; row < ROW; row++) {
            ArrayList<String> arr_row = new ArrayList<>();
            for (int column = 0; column < COLUMN; column++) {
                arr_row.add("0");
            }
            board.add(arr_row);
        }
    }

    public void setRow(int row) {
        this.ROW = row;
    }

    public void setColumn(int column) {
        this.COLUMN = column;
    }

    public int getRow() {
        return this.ROW;
    }

    public int getColumn() {
        return this.COLUMN;
    }

    public void write(int column, int row, String value) {
        board.get(row).set(column, value);
    }

    public void clearBoard() {
        createBoard();
    }

    public void print() {
        for (int row = 0; row < ROW; row++) {
            for (int column = 0; column < COLUMN; column++) {
                System.out.print(board.get(row).get(column) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
