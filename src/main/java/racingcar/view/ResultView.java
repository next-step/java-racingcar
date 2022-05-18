package racingcar.view;

import racingcar.model.RacingCars;

public class ResultView {
    private ResultView() {

    }

    public static void printStatus(RacingCars racingCars) {
        racingCars.getValue().forEach(racingCar -> {
            System.out.println(racingCar.getName() + " : " + "-".repeat(racingCar.getStatus()));
        });
        System.out.println();
    }

    public static void printWinner(RacingCars racingCars) {
        racingCars = racingCars.extractWinner();
        StringBuilder stringWinner = new StringBuilder();
        for (int i = 0; i < racingCars.getValue().size(); i++) {
            stringWinner.append(racingCars.getValue().get(i).getName());
            if (i != racingCars.getValue().size() - 1) {
                stringWinner.append(",");
            }
        }
        System.out.println(stringWinner + "가 최종 우승했습니다.");
    }
}
