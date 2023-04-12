package step3;


public class RacingGame {

    private final RandomGenerator randomGenerator;
    Cars cars;

    public RacingGame() {
        randomGenerator = new RandomGenerator();
        cars = new Cars();
    }

    public void initCars(int numberOfCars) {
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
    }

    public Integer getRandomValue() {
        return randomGenerator.getValue();
    }

    public Cars getCars() {
        return cars;
    }
}
