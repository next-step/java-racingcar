package carracing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Cars{

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getCarsSize() {
        return cars.size();
    }

    public static Cars makeCars(String[] ParticipantsName) {
        List<Car> carList = makeCarList(ParticipantsName);
        Cars cars = new Cars(carList);
        return cars;
    }

    public void moveCars(RandomGenerator randomGenerator) {
        IntStream.range(0, cars.size())
                .forEach(i -> cars.get(i).move(randomGenerator.makeRandomValue()));
    }

    private static List<Car> makeCarList(String[] ParticipantsName) {
        List<Car> carList = new ArrayList<>();
        for (String name : ParticipantsName) {
            carList.add(new Car(name));
        }
        return carList;
    }

}
