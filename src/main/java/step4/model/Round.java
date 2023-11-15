package step4.model;

public class Round {

    private final RacingCars racingCars;

    private final NumberGenerator numberGenerator;

    public Round(RacingCars racingCars, NumberGenerator numberGenerator) {
        this.racingCars = racingCars;
        this.numberGenerator = numberGenerator;
    }

    public void run(String movingStr) {
        for (Car car : racingCars.getCars()) {
            car.move(numberGenerator, movingStr);
            System.out.println(String.format("%s : %s", car.getName(), car.getMoving().getDistanceStr(movingStr)));
        }
    }
}
