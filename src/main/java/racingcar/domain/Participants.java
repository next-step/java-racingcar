package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.car.Move;
import racingcar.domain.random.RandomGenerator;

public class Participants {

    private final List<Car> cars;
    private final Move move;

    private Participants(List<Car> cars) {
        this.cars = cars;
        this.move = Move.get();
    }

    public static Participants getInstance(List<Car> cars) {
        return new Participants(cars);
    }

    public static Participants toParticipants(RacingResult racingResult) {
        return Participants.getInstance(racingResult.getResult());
    }

    public static Participants createCars(String[] names) {
        List<Car> cars;
        cars = Arrays.stream(names)
            .map(name -> Car.from(name.trim()))
            .collect(Collectors.toList());
        return Participants.getInstance(cars);
    }

    public RacingResult race() {
        int carSize = cars.size();
        for (int i = 0; i < carSize; i++) {
            moveCarIfPositionChanged(i, move.isSatisfiedMoveCondition(new RandomGenerator()));
        }

        return RacingResult.getInstance(cars);
    }

    public void moveCarIfPositionChanged(int index, boolean bool) {
        if (bool) {
            this.cars.get(index).go();
        }
    }

    public List<Car> getParticipants() {
        return this.cars;
    }

    public int getParticipantCount() {
        return cars.size();
    }
}