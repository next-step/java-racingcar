package racinggame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static utils.ConstantCollection.FORWARD_NUMBER;
import static utils.ConstantCollection.RANGE_RANDOM;
import static utils.GenerateRandom.generatingRandomNumber;
import static utils.Separator.separateName;

public class Racing {
    private List<Car> cars;                 // 자동차들을 저장하는 리스트
    private int tryGame;                    // 시도할 횟수

    // 사용자에게 입력받은 자동차 회수와 game 횟수를 저장하는 생성자
    public Racing(String carsName, int CountCar, int tryGame) {
        cars = new ArrayList<>();

        //이름을 하나씩 분리해주는 메서드
        String [] names = separateName(carsName);

        if (names.length != CountCar) {
            throw new IllegalArgumentException();
        }

        for(int i = 0; i < CountCar; i++) {
            cars.add(new Car(names[i]));
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

        int maxMovement = getMaxMovement();

        for(Car car : this.cars) {
            if (car.isWinner(maxMovement)) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public int getMaxMovement() {
        List<Integer> carsMovement = new ArrayList<>();

        for(Car car : this.cars) {
            carsMovement.add(car.getCountMoving());
        }

        return carsMovement.isEmpty() ? -1 : Collections.max(carsMovement);
    }

    // 난수를 생성하여 자동차가 움직일지의 전진 여부를 결정하여 추가하는 메서드
    public void carForwardStatus() {
        for(Car car : this.cars) {
            if(isCarMoving()){
                car.move();
            }
        }
    }

    public boolean isCarMoving() {
        int random = generatingRandomNumber(RANGE_RANDOM);
        // 난수가 4이상인 경우 전진한다.
        if (random >= FORWARD_NUMBER) {
            return true;
        }
        return false;
    }

}
