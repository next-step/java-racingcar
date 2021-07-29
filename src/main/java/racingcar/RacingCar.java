/*
 *   Class name : RacingCar.java
 *   Version : 0.0.1
 *   Date : 2021/07/24
 */

package racingcar;

import java.util.*;

/**
 * 해당 클래스는 Racing을 하기 위한 기능이 구현되어있는 클래스입니다.
 */
public class RacingCar {

    private final String[] carNames;   // 자동차 대 수
    private final int moveCount; // 자동차 이동 횟수

    public RacingCar(String[] carNames, int moveCount) {

        this.carNames = carNames;
        this.moveCount = moveCount;
    }

    /**
     * Racing에 필요한 Car의 입력 갯수만큼 생성합니다.
     * @return List<Car>
     */
    public List<Car> createAsCarsNumberOfEnteredByUser() {

        List<Car> cars = new ArrayList<Car>();
        for (int i = 0; i < this.carNames.length; i++) {
            Car car = new Car();
            car.setCarName(this.carNames[i]);
            cars.add(car);
        }
        return cars;
    }

    /**
     * 준비된 Car 객채들 끼리의 경주를 시작합니다.
     */
    public List<Car> doRacingStart(List<Car> cars) {

        for (int i = 0; i < this.moveCount; i++) {
            moveAsCarUserEntered(cars);
        }
        return cars;
    }

    /**
     * 사용자가 입력한 횟수만큼 자동차들을 움직입니다.
     * @param cars
     */
    public void moveAsCarUserEntered(List<Car> cars) {

        for (Car car : cars) {
            car.moveCar();
            drawCarMoving(car);
        }
        System.out.println();
    }

    /**
     * 자동차가 이동하는것을 그립니다.
     * @param car
     */
    public void drawCarMoving(Car car) {

        System.out.printf(car.getCarName() + " : ");
        for (int j = 0; j < car.getCurrentLocation(); j++) {
            System.out.printf("-");
        }
        System.out.println();
    }

    public List<Car> whoIsWinner(List<Car> cars) {

        int winnerLocation = getWinnerLocation(cars);

        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getCurrentLocation() == winnerLocation) {
                winners.add(car);
            }
        }

        return winners;

    }

    private int getWinnerLocation(List<Car> cars) {

        int maxLocation = cars.get(0).getCurrentLocation();

        for (Car car : cars) {
            if(maxLocation < car.getCurrentLocation()) {
                maxLocation = car.getCurrentLocation();
            }
        }

        return maxLocation;
    }
}
