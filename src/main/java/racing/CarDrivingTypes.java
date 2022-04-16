package racing;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class CarDrivingTypes implements Iterable<CarDrivingType> {
    private final List<CarDrivingType> carDrivingTypes;

    public CarDrivingTypes(List<CarDrivingType> carDrivingTypes) {
        this.carDrivingTypes = carDrivingTypes;
    }

    public void add(CarDrivingType carDriving) {
        carDrivingTypes.add(carDriving);
    }

    public int getGoMovingCount() {
        return (int) carDrivingTypes.stream()
                .filter(c -> c.equals(CarDrivingType.GO))
                .count();
    }

    public int getStopMovingCount() {
        return (int) carDrivingTypes.stream()
                .filter(c -> c.equals(CarDrivingType.STOP))
                .count();
    }

    public int getAllMovingCount() {
        return (int) carDrivingTypes.size();
    }

    public CarDrivingType getCarDrivingType(int attemptsNumber) {
        return carDrivingTypes.get(attemptsNumber);
    }

    public Stream<CarDrivingType> stream() {
        return carDrivingTypes.stream();
    }

    @Override
    public Iterator<CarDrivingType> iterator() {
        return carDrivingTypes.iterator();
    }
}
