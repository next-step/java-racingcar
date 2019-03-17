package racinggame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static utils.ConstantCollection.*;
import static utils.GenerateRandom.generatingRandomNumber;
import static utils.Separator.separateName;

public class Racing {
    private List<Car> cars;                 // 자동차들을 저장하는 리스트
    private int tryGame;                    // 시도할 횟수

    // 사용자에게 입력받은 자동차 회수와 game 횟수를 저장하는 생성자
    public Racing(String carsName, int tryGame) {
        cars = new ArrayList<>();

        //이름을 하나씩 분리해주는 메서드
        String [] names = separateName(carsName);

        for(int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }

        this.tryGame = tryGame;
    }

    public Racing(String carsName) {
        cars = new ArrayList<>();

        //이름을 하나씩 분리해주는 메서드
        String [] names = separateName(carsName);
        int countCars = names.length;

        for(int i = 0; i < countCars; i++) {
            cars.add(new Car(names[i]));
        }
    }

    public int getTryGame() {
        return tryGame;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();

        if(getMaxMovement() == EXCEPTION_VALUE) {
            throw new IllegalArgumentException();
        }
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

        return carsMovement.isEmpty() ? EXCEPTION_VALUE : Collections.max(carsMovement);
    }

    // 난수를 생성하여 자동차가 움직일지의 전진 여부를 결정하여 추가하는 메서드
    public void carForwardStatus() {
        for(Car car : this.cars) {
            int random = generatingRandomNumber(RANGE_RANDOM);
            if(isCarMoving(random)){
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
