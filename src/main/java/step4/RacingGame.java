/*
 * 자동차 경주 게임을 진행하는 클래스
 * */

package step4;

import java.util.*;


public class RacingGame {
    private List<Car> carList;

    public RacingGame(String[] racerNames) {
        this.carList = makeCarList(racerNames);
    }

    /**
     * 입력받은 자동차 이름으로 자동차 클래스의 리스트를 만드는 메소드
     */
    private List<Car> makeCarList(String[] racerNames) {
        carList = new ArrayList<>();

        for (String racerName : racerNames) {
            Car car = new Car(Constants.INITIAL_POSITION, racerName);
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
