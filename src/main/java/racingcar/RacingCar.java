/*
 *   Class name : RacingCar.java
 *   Version : 0.0.1
 *   Date : 2021/07/24
 */

package racingcar;

import java.util.ArrayList;
import java.util.List;

/**
 * 해당 클래스는 Racing을 하기 위한 기능이 구현되어있는 클래스입니다.
 */
public class RacingCar {

    private final String[] carNames;   // 자동차 대 수
    private final int moveCount; // 자동차 이동 횟수
    private final int range = 10; // 자동차 최대 이동거리

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
     * 사용자가 입력한 횟수만큼 자동차들을 움직입니다.
     * @param cars
     */
    public void moveAsCarUserEntered(List<Car> cars) {

        for (Car car : cars) {
            car.moveCar(range);
        }

        drawCarMoving(cars);
    }

    /**
     * 준비된 Car 객채들 끼리의 경주를 시작합니다.
     */
    public List<Car> doRacingStart(List<Car> cars) {

        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < this.moveCount; i++) {
            moveAsCarUserEntered(cars);
        }
        return cars;
    }

    /**
     * 승리한 자동차를 반환합니다.
     * @param cars
     * @return
     */
    public List<Car> getWinners(List<Car> cars) {

        int winnerLocation = getWinnerLocation(cars);

        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getCurrentLocation() == winnerLocation) {
                winners.add(car);
            }
        }

        return winners;

    }

    /**
     * 자동차들 중 가장 멀리간 자동차의 위치를 반환합니다.
     * @param cars
     * @return
     */
    public int getWinnerLocation(List<Car> cars) {

        int maxLocation = cars.get(0).getCurrentLocation();

        for (Car car : cars) {
            if(maxLocation < car.getCurrentLocation()) {
                maxLocation = car.getCurrentLocation();
            }
        }

        return maxLocation;
    }

    /**
     * RacingCar 실행함수
     */
    public void start() {

        List<Car> carsAfterTheRace = this.doRacingStart(this.createAsCarsNumberOfEnteredByUser());
        List<Car> winners = this.getWinners(carsAfterTheRace);
        drawWinnerView(winners);
    }

    /**
     * RacingCar 승자를 그립니다.
     * @param winners
     */
    public void drawWinnerView(List<Car> winners) {

        StringBuffer sb = new StringBuffer();
        for (Car winner : winners) {
            sb.append(winner.getCarName() + ",");
        }
        System.out.println(sb.toString().substring(0,sb.toString().lastIndexOf(',')) + "가 최종 우승했습니다.");
    }

    /**
     * 자동차들이 이동하는것을 그립니다.
     * @param cars
     */
    public void drawCarMoving(List<Car> cars) {

        for (Car car : cars) {
            drawUI(car);
        }
        System.out.println();
    }

    /**
     * 자동차가 움직인 만큼 UI 를 그립니다.
     * @param car
     */
    public void drawUI(Car car) {

        System.out.printf(car.getCarName() + " : ");
        for (int j = 0; j < car.getCurrentLocation(); j++) {
            System.out.printf("-");
        }
        System.out.println();
    }


}
