package step3.racingcar;

public class GameResultBoard {

    private int row;
    private int column;

    public GameResultBoard(String[] carNames, int gameTryCounts) {
        this.row = carNames.length;
        this.column = gameTryCounts;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
