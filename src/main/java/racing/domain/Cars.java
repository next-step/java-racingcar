package racing.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    private static final String COMMA = ",";
    private final PowerGenerator powerGenerator;
    private final List<Car> cars;

    public Cars(String carNames, PowerGenerator powerGenerator) {
        validate(carNames);
        this.cars = Stream.of(carNames.split(COMMA))
                .map(name -> new Car(new CarName(name)))
                .collect(Collectors.toList());

        this.powerGenerator = powerGenerator;
    }

    Cars(List<Car> cars, PowerGenerator powerGenerator) {
        this.cars = cars;
        this.powerGenerator = powerGenerator;
    }

    public void move() {
        cars.forEach(car -> car.move(powerGenerator.generate()));
    }

    public List<Car> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .reduce(Math::max)
                .getAsInt();

        return cars.stream()
                .filter(car -> maxPosition == car.getPosition())
                .collect(Collectors.toList());
    }

    private void validate(String names) {
        if (StringUtils.isBlank(names)) {
            throw new IllegalArgumentException("잘못된 자동차 이름입니다.");
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public int size() {
        return cars.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
