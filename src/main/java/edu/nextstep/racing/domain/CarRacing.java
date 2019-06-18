package edu.nextstep.racing.domain;

import edu.nextstep.racing.model.Car;
import edu.nextstep.racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-15 23:33
 */
public class CarRacing implements CarRacingInterface {

    private List<Car> carList;
    private final int MOVE_COUNT;
    private static final int MOVE_LIMIT_COUNT_FLAG = 4;
    private static final int MOVE_MAX_VALUE = 9;
    private static final int MIN_VALUE = 0;

    private ResultView output = new ResultView();

    public List<Car> getCarList() {
        return carList;
    }

    /*
    CarRacing 생성자
    @parameter carCount, moveCount
     */
    public CarRacing(int carCount, int moveCount) {
        checkArgumentException(carCount, moveCount);

        this.carList = initCarList(carCount);
        MOVE_COUNT = moveCount;
    }

    /*
    자동차 경주 시작 메서드
    @return List<Car>
     */
    @Override
    public List<Car> move() {
        for (int i = 0; i < MOVE_COUNT; i++) {
            doMove();
        }
        return this.carList;
    }

    /*
    자동차 대수 및 위치 초기화
    @return List<Car>
     */
    private List<Car> initCarList(int carCount) {
        List<Car> returnCarList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            returnCarList.add(new Car(""));
        }
        return returnCarList;
    }

    private void checkArgumentException(int carCount, int moveCount) {
        if (carCount <= MIN_VALUE || moveCount <= MIN_VALUE) {
            throw new IllegalArgumentException("입력한 데이터의 값이 0보다 작습니다." + " [자동차 대수] :" + carCount + " [시도횟수] : " + moveCount);
        }
    }

    /*
    전진 수행을 위한 메서드
     */
    private void doMove() {
        for (int i = 0; i < this.carList.size(); i++) {
            doMoveCheck(this.carList.get(i));
        }
        // 전진 완료 후 출력
        output.resultView(this.carList);
    }

    /*
    각각의 자동차의 전진 체크
     */
    private void doMoveCheck(Car targetCar) {
        if (isMoving()) {
            targetCar.move();
        }
    }

    /*
    전진여부 판단
    @return boolean type
     */
    private boolean isMoving() {
        Random generator = new Random();
        int limit = generator.nextInt(MOVE_MAX_VALUE);
        if (limit >= MOVE_LIMIT_COUNT_FLAG) {
            return true;
        }
        return false;
    }
}