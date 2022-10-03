package model;

import dto.RacingCars;
import service.RacingCarService;

import java.util.List;

public class RacingCarWithoutWinner implements Result {
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

        RacingCarService racingCarService = new RacingCarService();
        System.out.println(racingCarService.findRaceWinners(cars) + "가 최종 우승했습니다.");
    }

    @Override
    public void raceResult(RacingCars racingCars, int numOfRaces) {
        for (int count = 1; count <= numOfRaces; count++) {
            racingCars.move();
            outputCarsLocation(racingCars.distance());
        }
    }

    private void outputCarsLocation(List<Integer> carsLocation) {
        for (int distance : carsLocation) {
            System.out.println(createCarDistanceBar(distance));
        }
        System.out.println();
    }
}
