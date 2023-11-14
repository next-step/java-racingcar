package study.racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {

    private static final String DELIMITER = ", ";
    private static final int MANY_WINNERS = 0;
    private static final int DEFAULT_POSITION = 1;
    private static final int RANDOM_RANGE = 10;
    private static final String NEXT_LINE = "\n";
    private final List<Car> value;

    public Cars(Names names) {

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < names.size(); i++) {
            cars.add(new Car(names.getName(i), new Position(DEFAULT_POSITION)));
        }

        this.value = cars;
    }

    public String move(NumberGenerator randomGenerator, TryCounts tryCounts) {

        StringBuilder positionBuilder = new StringBuilder();

        for (int i = 0; i < tryCounts.getValue(); i++) {
            positionBuilder.append(moveEachCar(randomGenerator));
            positionBuilder.append(NEXT_LINE);
        }

        return positionBuilder.toString();
    }

    private String moveEachCar(NumberGenerator randomGenerator) {

        StringBuilder positionBuilder = new StringBuilder();

        for (Car car : value) {
            String dash = car.move(randomGenerator.random(RANDOM_RANGE));
            positionBuilder.append(dash).append(NEXT_LINE);
        }

        return positionBuilder.toString();
    }

    public String findWinners() {
        StringBuilder winners = new StringBuilder();

        int maxPosition = findMaxPosition();

        List<Car> winningCars = findWinners(maxPosition);

        // 우승자 목록 반환
        for (Car car : winningCars) {
            if (winners.length() > MANY_WINNERS) {
                winners.append(DELIMITER);
            }
            winners.append(car.getName().getValue());
        }

        return winners.toString();
    }

    private List<Car> findWinners(int maxPosition) {

        return value.stream()
                .filter(car -> car.getPosition().getValue() == maxPosition)
                .collect(Collectors.toList());
    }

    private int findMaxPosition() {

        return value.stream()
                .mapToInt(car -> car.getPosition().getValue())
                .max()
                .orElse(DEFAULT_POSITION);
    }

    public List<Car> getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars = (Cars) o;
        return Objects.equals(value, cars.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
