package step3.racingcar;

public class GameResultBoard {

    private int[][] gameResultBoard;
    private String[] carNames;

    public GameResultBoard(String[] carNames, int gameTryCounts) {
        int row = carNames.length;
        int column = gameTryCounts;
        this.gameResultBoard = new int[row][column];
        this.carNames = carNames;
    }

    public int[][] getGameResultBoard() {
        return gameResultBoard;
    }

    public String[] getCarNames() {
        return carNames;
    }
}
