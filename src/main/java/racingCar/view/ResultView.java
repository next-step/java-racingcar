package racingCar.view;

import racingCar.model.RacingCar;
import racingCar.util.RacingCarUtil;

import java.util.List;

public class ResultView {

    public void printResultTitle() {
        System.out.println("실행 결과");
    }

    private void printCarDistance(RacingCar racingCar) {

        int carDistance = racingCar.distance();

        for (int distance = 0; distance < carDistance; distance++) {
            System.out.print("-");
        }

        System.out.println();
    }

    private void printCarNameAndDistance(RacingCar racingCar) {

        System.out.print(racingCar.name() + " : ");

        printCarDistance(racingCar);
    }

    public void printCarsDistance(List<RacingCar> racingCars) {

        for (int carIndex = 0; carIndex < racingCars.size(); carIndex++) {
            printCarDistance(racingCars.get(carIndex));
        }

        System.out.println();
    }

    public void printCarsNameAndDistance(List<RacingCar> racingCars) {

        for (int carIndex = 0; carIndex < racingCars.size(); carIndex++) {
            printCarNameAndDistance(racingCars.get(carIndex));
        }

        System.out.println();
    }

    public void printRaceWinner(List<RacingCar> racingCars) {

        List<String> winners = RacingCarUtil.maxDistanceWinners(racingCars);
        String winnersStr = RacingCarUtil.winnersToString(winners);

        System.out.println(winnersStr + "가 최종 우승했습니다.");
    }
}
