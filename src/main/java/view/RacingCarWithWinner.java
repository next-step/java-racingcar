package view;

import domain.racingcar.dto.RandomMovingStrategy;
import domain.racingcar.dto.RacingCar;
import domain.racingcar.RacingCars;

import java.util.List;

public class RacingCarWithWinner implements Result {
    @Override
    public void view() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String racingCars = InputView.inputString();

        String[] racingCarNames = racingCars.split(",");
        RacingCars cars = new RacingCars(racingCarNames);

        System.out.println("시도할 회수는 몇 회 인가요?");
        int races = InputView.inputInteger();

        System.out.println("실행 결과");
        raceResult(cars, races);

        System.out.println(cars.findRaceWinners() + "가 최종 우승했습니다.");
    }

    @Override
    public void raceResult(RacingCars racingCars, int numOfRaces) {
        for (int count = 1; count <= numOfRaces; count++) {
            outputCarsLocation(racingCars.move(new RandomMovingStrategy()));
        }
    }

    private void outputCarsLocation(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            System.out.println(racingCar.getName() + " : " + createCarDistanceBar(racingCar.getDistance()));
        }

        System.out.println();
    }
}
