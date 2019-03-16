package racingcar;

import racingcar.utils.Constant;

import java.util.List;

public class RacingResult {
    RacingGame racingGame;
    int tryNo;

    public RacingResult(RacingGame racingGame, int tryNo) {
        this.racingGame = racingGame;
        this.tryNo = tryNo;
    }

    public static String formatLastCharacterRemove(String strings) {
        return strings.replaceAll(Constant.FORMAT_REGULAR_LAST_COMMA, "");
    }

    public void printBattle() {
        for (int i = 0; i < tryNo; i++)
            setRandomValue(racingGame.getRandomValue());
    }

    public void printWinner() {
        StringBuilder winnerNamesBuilder = new StringBuilder();
        winnerNamesBuilder.append(formatLastCharacterRemove(racingGame.getWinnerName()));
        winnerNamesBuilder.append("가 최종 우승했습니다.");
        System.out.println(winnerNamesBuilder.toString());
    }

    public void setRandomValue(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars)
            System.out.println(racingCar.getName() + Constant.FORMAT_COLON + getRandomString(racingCar.getCoordinate()));
        System.out.println("\n");
    }

    public String getRandomString(int coordinate) {
        StringBuilder coordinateString = new StringBuilder();
        for (int i = 0; i < coordinate; i++)
            coordinateString.append("-");
        return coordinateString.toString();
    }
}
