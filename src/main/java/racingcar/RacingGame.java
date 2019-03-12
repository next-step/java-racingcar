package racingcar;

import racingcar.car.Car;
import racingcar.view.RacingGameStatusViewer;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int time;
    private List<Car> cars;

    public RacingGame(int numberOfCars, int time) {
        this.time = time;
        registerRacer(numberOfCars);
    }

    public void registerRacer(int numberOfCars) {
        cars = new ArrayList<Car>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car(0));
        }
    }

    public void game() {
        for (int i = 0; i < time; i++) {
            move();
        }
    }

    public void move() {
        for(Car car : cars) {
            int position = car.move();
            RacingGameStatusViewer.showStatus(position);
        }
        RacingGameStatusViewer.nextTurn();
    }

    //19.03.10 - step1 피드백, movePower 객체로 분리

    //19.03.10 - step1 피드백, 테스트를 위한 인스턴스 변수 getter제거
    //대신 최종결과를 확인하기 위한 method 생성
    public List<Car> loadResultofGame() {
        return cars;
    }
}

