package view;

import domain.racingcar.dto.RandomMovingStrategy;
import domain.racingcar.dto.RacingCar;
import domain.racingcar.RacingCars;

import java.util.List;

public class RacingCarWithoutWinner implements Result {
    @Override
    public void view() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int numOfCars = InputView.inputInteger();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int races = InputView.inputInteger();

        System.out.println("실행 결과");
        RacingCars racingCars = new RacingCars(numOfCars);

        raceResult(racingCars, races);
    }

    @Override
    public void raceResult(RacingCars racingCars, int numOfRaces) {
        for (int count = 1; count <= numOfRaces; count++) {
            outputCarsLocation(racingCars.move(new RandomMovingStrategy()));
        }
    }

    private void outputCarsLocation(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            System.out.println(createCarDistanceBar(racingCar.getDistance()));
        }
        System.out.println();
    }
}
