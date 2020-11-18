package view;

import domain.CarName;
import domain.RacingCar;
import domain.RacingCarGroups;

import java.util.List;

public final class ResultView {
    public static void displayWinner(List<CarName> winners) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            stringBuilder.append(winners.get(i).getName()).append(", ");
        }
        System.out.print(stringBuilder.substring(0, stringBuilder.length() - 2) + "가 최종 우승했습니다.");
    }

    public static void displayRacingCarGroup(RacingCarGroups racingCarGroups) {
        for(int i = 0; i < racingCarGroups.getRacingCars().size(); i++) {
            displayRacingCar(racingCarGroups.getRacingCars().get(i));
        }
        System.out.println();
    }

    public static void displayRacingCar(RacingCar racingCar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(racingCar.getCarName()).append(" : ");
        for(int i = 0; i < racingCar.getCarDistance().getDistance(); i++) {
            stringBuilder.append("-");
        }
        System.out.println(stringBuilder);
    }
}
