/*
 * 자동차 경주 게임을 진행하는 클래스
 * */

package step4;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> carList;

    public RacingGame(int carNumber) {
        this.carList = this.makeCarList(carNumber);
    }

    /**
     * 입력받은 자동차 대수로 자동차 클래스의 리스트를 만드는 메소드
     */
    public List<Car> makeCarList(int carNumber) {
        carList = new ArrayList<>();

        for (int i = 0; i < carNumber; i++) {
            Car car = new Car(Constants.INITIAL_POSITION);
            carList.add(car);
        }

        return carList;
    }

    /**
     * 자동차 경주 게임을 실행하는 메소드, 각 라운드를 실행하고 자동차들의 위치를 변경한다
     */
    public void playRace() {
        for (Car car : getCars()) {
            playEachCar(car);
        }
    }

    /**
     * 매 라운드마다 자동차의 전진 조건을 파악하여 자동차의 위치를 변경하는 메소드
     */
    private void playEachCar(Car car) {
        car.move();
    }

    /**
     * RacingGame 클래스에서 관리하는 자동차 리스트 반환
     * */
    public List<Car> getCars() {
        return this.carList;
    }
}
