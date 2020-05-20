package racingCar.ui;

import racingCar.domain.RacingCar;

import java.util.List;

public class ResultView {
    private StringBuilder stringBuilder;

    public void printCarsPosition(List<RacingCar> racingCarList) {
        stringBuilder = new StringBuilder();

        for (RacingCar racingCar : racingCarList) {
            stringBuilder.append(racingCar.getName()).append(" : ");
            printPosition(racingCar);
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder.toString());
    }

    public void printWinnerNames(List<RacingCar> winners) {
        stringBuilder = new StringBuilder();

        winners.stream().map(RacingCar::getName).forEach(value -> stringBuilder.append(value).append(", "));

        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append("가 최종 우승했습니다.");
        System.out.println(stringBuilder.toString());
    }

    private void printPosition(RacingCar racingCar) {
        for (int idx = 0; idx < racingCar.getPosition(); idx++) {
            stringBuilder.append("-");
        }
    }
}
