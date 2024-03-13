package racingcar.repository;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RacingRepository {
    private List[] cars;

    private final int GO_CONDITION = 4;
    private final int GO_CONDITION_START_INDEX = 0;
    private final int GO_CONDITION_END_INDEX = 9;

    public void makeCars(int input) {
        cars = new List[input];
        for (int i = 0; i < input; i++) {
            cars[i] = new LinkedList<>();
        }
    }

    public void moveCar(RacingRepository racingRepository) {

        for (List car : racingRepository.cars) {
            if (stopOrGo(GO_CONDITION_START_INDEX, GO_CONDITION_END_INDEX, GO_CONDITION)) car.add('-');
            CarLocation(car);
        }
    }

    private boolean stopOrGo(int start, int end, int condition) {
        return ThreadLocalRandom.current().nextInt(start, end) >= condition;
    }

    private void CarLocation(List<Character> Car) {
        for (Character c : Car) {
            System.out.print(c);
        }
    }
}
