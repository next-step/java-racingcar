package racinggame.domain.racing;

import racinggame.domain.car.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. Car의 List 필드
 * 1. 레이싱 1 라운드를 진행
 * 1. 전체 라운드 수 만큼 자동차 이동
 */
public class Racing {
    private List<Car> cars = new ArrayList<>();

    public Racing(List<Car> cars) {
        this.cars = cars;
    }

//    public void racingGameStart(int gameCount, List<Car> cars) {
//        for (int i = 0; i < gameCount; i++) {
//            playOneRound(cars);
//        }
//    }

    public void playOneRound() {
        for (Car car : cars) {
            car.moveCar();
        }
    }
}
