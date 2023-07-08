package racingcar;

import racingcar.number_generator.NumberGenerator;
import racingcar.number_generator.RandomNumberGenerator;

public class Car {

    private static final int FORWARD_THRESHOLD = 4;

    private final CarName name;
    private final NumberGenerator numberGenerator;
    private final Distance distance;


    public Car(String name, NumberGenerator numberGenerator, int distance) {
        this.name = new CarName(name);
        this.numberGenerator = numberGenerator;
        this.distance = new Distance(distance);
    }

    public Car(String name, int distance) {
        this(name, new RandomNumberGenerator(), distance);
    }

    Car(String name, NumberGenerator numberGenerator) {
        this.name = new CarName(name);
        this.numberGenerator = numberGenerator;
        this.distance = new Distance();
    }

    public Car(String name) {
        this(name, new RandomNumberGenerator());
    }

    public void progress() {
        if (canMove()) {
            distance.increase();
        }
    }

    private boolean canMove() {
        return numberGenerator.generate() >= FORWARD_THRESHOLD;
    }

    public boolean isSameDistance(int maxDistance) {
        return this.distance.isSameDistance(maxDistance);
    }

    public boolean isSameDistance(Car car) {
        return this.distance.isSameDistance(car.distance);
    }

    public Car returnFurtherMovedCar(Car car) {
        if (this.distance.isGreaterThan(car.distance)) {
            return this;
        }
        
        return car;
    }

    public String getName() {
        return name.getCarName();
    }

    public int getDistance() {
        return distance.getDistance();
    }


}
