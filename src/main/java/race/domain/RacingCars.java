package race.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<RacingCar> racingCars;

    public static RacingCars from(List<String> carNames) {
        return new RacingCars(carNames.stream()
                .map(RacingCar::new)
                .collect(Collectors.toList())
        );
    }

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public int count() {
        return racingCars.size();
    }

    public List<String> moveAndReturnCarStateMessages(List<Integer> numbers) {
        if (numbers.size() != racingCars.size()) {
            throw new IllegalArgumentException("입력값들의 개수는 자동차의 개수와 같아야 합니다");
        }

        List<String> carStatesMessages = new ArrayList<>();

        for (int carIndex = 0; carIndex < racingCars.size(); carIndex++) {
            RacingCar car = racingCars.get(carIndex);
            car.moveCarForwardIfCanGo(numbers.get(carIndex));

            String carStateMessage = car.makeCarStateMessage();
            carStatesMessages.add(carStateMessage);
        }

        return carStatesMessages;
    }

    public List<String> findWinners() {
        int maxState = maxState();

        return racingCars.stream()
                .filter(car -> car.isStateEqualWith(maxState))
                .map(RacingCar::name)
                .collect(Collectors.toList());
    }

    private int maxState() {
        int maxState = 0;

        for (RacingCar car : racingCars) {
            maxState = car.max(maxState);
        }

        return maxState;
    }
}
