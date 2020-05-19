package step3.racingcar;

import java.util.List;

public class GameResultBoard {

    private int[][] gameResultBoard;
    private String[] carNames;

    public GameResultBoard(String[] carNames, int gameTryCounts) {
        int row = carNames.length;
        int column = gameTryCounts;
        this.gameResultBoard = new int[row][column];
        this.carNames = carNames;
    }

    public void recordRound(List<Car> cars, int roundNumber) {
        int row = cars.size();
        for (int carNumber = 0; carNumber < row; carNumber++) {
            this.gameResultBoard[carNumber][roundNumber] = cars.get(carNumber).getPosition();
        }
    }

    public int[][] getGameResultBoard() {
        return gameResultBoard;
    }

    public String[] getCarNames() {
        return carNames;
    }
}
