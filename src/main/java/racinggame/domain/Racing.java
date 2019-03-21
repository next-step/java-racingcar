package racinggame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static utils.GenerateRandom.generatingRandomNumber;
import static utils.Separator.separateName;

public class Racing {
    final static int RANGE_RANDOM = 10;
    public static final int EXCEPTION_VALUE = -1;
    public static final int FORWARD_NUMBER = 4;

    private List<Car> cars;                 // 자동차들을 저장하는 리스트
    private int tryGame;                    // 시도할 횟수

    public Racing(String carsName, int tryGame) {
        this.cars = new ArrayList<>();

        String [] names = separateName(carsName);

        for (int i = 0; i < names.length; i++) {
            this.cars.add(new Car(names[i]));
        }

        this.tryGame = tryGame;
    }

    public int getTryGame() {
        return tryGame;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();

        if (getMaxMovement() == EXCEPTION_VALUE) {
            throw new IllegalArgumentException();
        }
        int maxMovement = getMaxMovement();

        for (Car car : this.cars) {
            if (car.isWinner(maxMovement)) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public int getMaxMovement() {
        List<Integer> carsMovement = new ArrayList<>();

        for (Car car : this.cars) {
            carsMovement.add(car.getCountMoving());
        }

        return carsMovement.isEmpty() ? EXCEPTION_VALUE : Collections.max(carsMovement);
    }

    // 난수를 생성하여 자동차가 움직일지의 전진 여부를 결정하여 추가하는 메서드
    public void carForwardStatus() {
        for (Car car : this.cars) {
            int random = generatingRandomNumber(RANGE_RANDOM);
            if (isCarMoving(random)){
                car.move();
            }
        }
    }

    public boolean isCarMoving(int random) {
        // 난수가 4이상인 경우 전진한다.
        if (random >= FORWARD_NUMBER) {
            return true;
        }
        return false;
    }

}
