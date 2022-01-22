package racingcar.domain;

import java.util.List;
import racingcar.domain.car.Car;

public class Participants {
    private final List<Car> cars;

    private Participants(List<Car> cars) {
        this.cars = cars;
    }

    public static Participants getInstance(List<Car> cars) {
        return new Participants(cars);
    }

    public List<Car> getParticipants() {
        return this.cars;
    }

    public int getParticipantCount() {
        return cars.size();
    }

    public void moveCarIfPositionChanged(int index, boolean bool) {
        if (bool) {
            this.cars.get(index).go();
        }
    }

    public static Participants toParticipants(RacingResult racingResult) {
        return Participants.getInstance(racingResult.getResult());
    }
}
