package racingcar.domain;

import java.util.*;

public class Cars {

    private final List<Car> cars;

    public Cars(String[] names) {
        this.cars = new ArrayList<>();
        for (String name : names) {
            this.cars.add(new Car(new Name(name)));
        }
    }

    // Constructor for UnitTest
    public Cars(Car... cars) {
        this.cars = Arrays.asList(cars);
    }

    public List<Car> get() {
        return Collections.unmodifiableList(cars);
    }

    public int size() {
        return cars.size();
    }

    public void move(CarMoveStrategy moveStrategy) {
        for (Car car : this.cars) {
            car.move(moveStrategy);
        }
    }

    public Distance findMaxDistance() {
        Distance maxDistance = new Distance();
        for (Car car : cars) {
            maxDistance = returnMaxDistance(maxDistance, car);
        }
        return maxDistance;
    }

    private Distance returnMaxDistance(Distance maxDistance, Car car) {
        Distance carDistance = car.getDistance();
        if (carDistance.greaterThan(maxDistance)) {
            maxDistance = carDistance;
        }
        return maxDistance;
    }

    public Winners getWinners() {
        Distance maxDistance = findMaxDistance();
        return new Winners(findNames(maxDistance));
    }

    private Names findNames(Distance maxDistance) {
        Map<Distance, Names> namesByDistanceMap = createNamesByDistanceMap();
        return namesByDistanceMap.get(maxDistance);
    }

    private Map<Distance, Names> createNamesByDistanceMap() {
        Map<Distance, Names> distanceNamesMap = new HashMap<>();
        for (Car car : this.cars) {
            putToMap(distanceNamesMap, car);
        }
        return distanceNamesMap;
    }

    private void putToMap(Map<Distance, Names> namesByDistanceMap, Car car) {
        Distance distance = car.getDistance();
        Name carName = car.getName();
        if (namesByDistanceMap.containsKey(distance)) {
            namesByDistanceMap.get(distance).add(carName);
            return;
        }

        Names names = new Names();
        names.add(carName);
        namesByDistanceMap.put(distance, names);
    }

}
