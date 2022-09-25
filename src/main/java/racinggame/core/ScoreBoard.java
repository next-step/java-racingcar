package racinggame.core;

import racinggame.exception.InvalidCarNumberException;
import racinggame.exception.InvalidDistanceNumberException;
import racinggame.exception.InvalidGameNumberException;

public class ScoreBoard {

    private final int[][] distanceBoard;

    public ScoreBoard(int numOfGame, int numOfCar) {
        distanceBoard = new int[numOfGame][numOfCar];
    }

    public int getNumOfGame() {
        return distanceBoard.length;
    }

    public int[] getDistanceOfGame(int numOfGame) {
        validateNumOfGame(numOfGame);
        return distanceBoard[numOfGame - 1];
    }

    public int getDistance(int gameNumber, int carNumber) {
        validateIndex(gameNumber, carNumber);
        return distanceBoard[gameNumber - 1][carNumber - 1];
    }

    public void setDistance(int distance, int gameNumber, int carNumber) {
        validateInputData(distance, gameNumber, carNumber);
        distanceBoard[gameNumber - 1][carNumber - 1] = distance;
    }

    private void validateNumOfGame(int gameNumber) {
        if (distanceBoard.length <= gameNumber - 1) {
            throw new InvalidGameNumberException();
        }
    }
    private void validateIndex(int gameNumber, int carNumber) {
        validateNumOfGame(gameNumber);

        if (distanceBoard[gameNumber - 1].length <= carNumber - 1) {
            throw new InvalidCarNumberException();
        }
    }

    private void validateInputData(int distance, int gameNumber, int carNumber) {
        validateIndex(gameNumber, carNumber);

        if (distance < 0) {
            throw new InvalidDistanceNumberException();
        }
    }

}
