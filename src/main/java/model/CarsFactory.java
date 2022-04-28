package model;

public class CarsFactory {
    public static Cars create(String carNames) {
        return new Cars(carNames);
    }
}
