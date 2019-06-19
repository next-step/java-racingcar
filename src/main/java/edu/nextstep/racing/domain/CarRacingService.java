package edu.nextstep.racing.domain;

import edu.nextstep.racing.model.Car;
import edu.nextstep.racing.model.Cars;
import edu.nextstep.racing.utils.NumberUtils;

import java.util.List;
import java.util.stream.Collectors;

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
public class CarRacingService {

    private Cars player;
    private static final int MOVE_LIMIT_COUNT_FLAG = 4;

    /*
    CarRacing 생성자
    @parameter carCount, moveCount
     */
    public CarRacingService(Cars player) {
        this.player = player;
    }

    public Cars startRoundGame() {
        List<Car> carList = this.player.getCars().stream()
                .peek(car -> doMoveCheck(car))
                .collect(Collectors.toList());

        this.player.setCars(carList);
        return this.player;
    }

    public Cars finishGame() {
        return this.player;
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
        if (NumberUtils.getRandomNumber() >= MOVE_LIMIT_COUNT_FLAG) {
            return true;
        }
        return false;
    }
}