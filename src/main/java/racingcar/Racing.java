package racingcar;

public class Racing {
    //    private final List<Car> cars;
    private final CarCollection carCollection;

    Racing(String carNames, int trialCount) {
        carCollection = buildCarCollection(carNames, trialCount);
    }

    private static CarCollection buildCarCollection(String carNames, int trialCount) {
        String[] names = carNames.split(",");
        CarCollection carCollection = new CarCollection();
        for (String name : names) {
            Car car = new Car(name, trialCount);
            carCollection.addCar(car);
        }
        return carCollection;
    }

    public CarCollection getCarCollection() {
        return carCollection;
    }
}
