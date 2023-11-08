package step3.view;

import step3.model.Car;
import step3.model.RacingCars;
import step3.model.Round;

public class ResultView {

    private static final String RESULT = "실행결과";

    private static final String MOVE = "-";

    private static final String ROUND_END = "";

    private final Integer rounds;

    private final Integer carNumber;

    public ResultView(Integer carNumber, Integer rounds) {
        this.rounds = rounds;
        this.carNumber = carNumber;
    }
    public void showRace() {
        System.out.println(RESULT);
        race();
    }

    private void race() {
        RacingCars racingCars = new RacingCars(carNumber);
        for (int i = 0; i < rounds; i++) {
            new Round(racingCars).race();
            showRacingCarsMovingDistance(racingCars);
            System.out.println(ROUND_END);
        }
    }

    private void showRacingCarsMovingDistance(RacingCars racingCars) {
        for (Car car : racingCars.getRacingCars()) {
            System.out.println(showCarMovingDistance(car));
        }
    }

    private String showCarMovingDistance(Car car) {
        StringBuilder distance = new StringBuilder();
        for (int i = 0; i < car.getMoving().getMovingDistance(); i++) {
            distance.append(MOVE);
        }
        return distance.toString();
    }
}
