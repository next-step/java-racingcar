package racinggame.mvc.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.IntSupplier;

public class RacingGame {

    private final List<Car> racer;
    private final IntSupplier numberSupplier;
    private int tryNo;

    public RacingGame(String carNames, int tryNo, IntSupplier numberSupplier) {
        if (tryNo < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }

        List<Car> cars = new ArrayList<>();
        for (String name : carNames.split(",", -1)) {
            String trimmedName = name.trim();
            if (trimmedName.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
            }
            cars.add(new Car(trimmedName));
        }
        this.racer = cars;
        this.tryNo = tryNo;
        this.numberSupplier = Objects.requireNonNull(numberSupplier);
    }

    public boolean isEnd() {
        return tryNo == 0;
    }

    public RacingResult race() {
        if (isEnd()) {
            throw new IllegalStateException("시도 횟수를 초과했습니다.");
        }

        for (Car car : racer) {
            car.move(numberSupplier.getAsInt());
        }
        tryNo--;

        List<Car> racers = racer.stream()
            .map(car -> new Car(car.getName(), car.getPosition()))
            .toList();
        List<Car> winners = isEnd() ? findWinners(racers) : List.of();
        return new RacingResult(racers, winners);
    }

    private List<Car> findWinners(List<Car> racers) {
        int farthestPosition = racers.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow();
        return racers.stream()
            .filter(car -> car.getPosition() == farthestPosition)
            .toList();
    }
}
