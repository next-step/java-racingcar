package racingcar;

import java.util.List;

public class ResultView {

    public void roundLogTrace(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            System.out.print(racingCar.getCarName() + " : ");
            distanceToHyphen(racingCar);
        }
        System.out.println();
    }

    private void distanceToHyphen(RacingCar racingCar) {
        String distance = racingCar.myDistanceToString();
        System.out.println(distance);
    }

    public void winnerLogTrace(List<String> winners) {
        for (String winner : winners) {
            System.out.print(winner + " ");
        }
        System.out.println("가 최종 우승했습니다.");
    }

}
