/*
 *   Class name : RacingCar.java
 *   Version : 0.0.1
 *   Date : 2021/07/24
 */

package racingCar;

import java.util.ArrayList;
import java.util.List;

/**
 * 해당 클래스는 Racing을 하기 위한 기능이 구현되어있는 클래스입니다.
 */
public class RacingCar {

    private int carCount;   // 자동차 대 수
    private int moveCount; // 자동차 이동 횟수

    public RacingCar(int carCount, int moveCount) {
        this.carCount = carCount;
        this.moveCount = moveCount;
    }

    /**
     * Racing에 필요한 Car의 입력 갯수만큼 생성합니다.
     * @return List<Car>
     */
    public List<Car> readyCar() {
        List<Car> cars = new ArrayList<Car>();
        for(int i = 0 ; i < this.carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }

}
