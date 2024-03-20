package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AttendedCars {
    public final List<Car> attendedCars;

    public AttendedCars(String nameOfCars) {
        this(createAttendedCarsWithName(nameOfCars));
    }

    public AttendedCars(List<Car> cars) {
        this.attendedCars = cars;
    }

    public List<Car> getAttendedCars() {
        return attendedCars;
    }

    private static List<Car> createAttendedCarsWithName(String nameOfCars) {
        String[] splittedName = nameOfCars.split(",");
        List<Car> attendedCars = new ArrayList<>();

        for (String name: splittedName) {
            attendedCars.add(new Car(name));
        }

        return attendedCars;
    }

    public int getAttendance() {
        return attendedCars.size();
    }

    public List<Car> getWinners() {
        int maxNum = this.getWinnerLocation();

        return this.attendedCars.stream()
                .filter(car -> car.isSameLocation(maxNum))
                .collect(Collectors.toList());
    }

    private int getWinnerLocation() {
        return attendedCars.stream()
                .mapToInt(Car::getCurrentLocation)
                .max().orElse(-1);
    }

    public void moveAttendedCars(int[] randomMovePoint) {
        if (randomMovePoint.length != this.getAttendance()) {
            throw new IllegalArgumentException("필요한 movePoint 수와 일치하지 않습니다.");
        }

        for (Car car: attendedCars) {
            car.move(randomMovePoint[attendedCars.indexOf(car)]);
        }
    }
}
