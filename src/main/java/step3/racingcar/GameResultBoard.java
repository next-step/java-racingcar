package step3.racingcar;

public class GameResultBoard {

    private int row;
    private int column;
    private String[] carNames;

    public GameResultBoard(String[] carNames, int gameTryCounts) {
        this.row = carNames.length;
        this.column = gameTryCounts;
        this.carNames = carNames;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public String[] getCarNames() {
        return carNames;
    }
}
