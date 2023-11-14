package step5.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public Cars() {}

    public Cars(String[] nameOfCars) {
        Arrays.stream(nameOfCars)
            .forEach(name -> cars.add(new Car(name)));
    }

    public Cars(List<Integer> positions) {
        positions.forEach(position -> cars.add(new Car(position)));
    }

    public Cars(List<String> nameOfCars, List<Integer> positions) {
        IntStream.range(0, nameOfCars.size())
            .forEach(i -> cars.add(new Car(nameOfCars.get(i), positions.get(i))));
    }

    public int getNumOfCars() {
        return cars.size();
    }

    public Car findCarBy(int idx) {
        if (isOutOfIndex(idx)) {
            throw new IndexOutOfBoundsException("해당 번호의 차량은 존재하지 않습니다.");
        }

        return cars.get(idx);
    }

    private boolean isOutOfIndex(int idx) {
        return idx >= cars.size() || idx < 0;
    }

    public void moveCarBy(int randomNum, int carNo) {
        cars.get(carNo).moveForward(randomNum);
    }

    public int findMaxPosition() {
        int zero = 0;

        return cars.stream()
            .mapToInt(car -> car.comparePosition(zero))
            .max()
            .orElse(zero);
    }

    public List<String> findCarNamesMovingLongest(int maxPosition) {
        return cars.stream()
            .filter(car -> car.isMaxPosition(maxPosition))
            .map(Car::carName)
            .collect(Collectors.toUnmodifiableList());
    }
}
