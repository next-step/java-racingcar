package racingcar;

import java.util.List;

public final class ResultView {
    public static void displayWinner(List<String> winners) {
        System.out.print(String.join(",", winners) + "가 최종 우승했습니다.");
    }

    public static void displayRacingCarGroup(RacingCarGroups racingCarGroups) {
        for(int i = 0; i < racingCarGroups.getRacingCars().size(); i++) {
            displayRacingCar(racingCarGroups.getRacingCars().get(i));
        }
        System.out.println();
    }

    public static void displayRacingCar(RacingCar racingCar) {
        System.out.print(racingCar.getName() + " : ");
        for(int i = 0; i < racingCar.getDistance(); i++) {
            System.out.print('-');
        }
        System.out.println();
    }
}
