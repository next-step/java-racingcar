package model;

import dto.RacingCars;

import java.util.List;

public class RacingCarWithWinner implements Result {
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
            racingCars.move();
            outputCarsLocation(racingCars);
        }
    }

    private void outputCarsLocation(RacingCars racingCars) {
        List<Integer> distances = racingCars.distance();
        List<String> names = racingCars.name();

        for (int index = 0; index < names.size(); index++) {
            System.out.println(names.get(index) + " : " + createCarDistanceBar(distances.get(index)));
        }
        System.out.println();
    }
}
