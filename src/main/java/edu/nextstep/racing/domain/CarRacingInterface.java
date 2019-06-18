package edu.nextstep.racing.domain;

import edu.nextstep.racing.model.Car;

import java.util.List;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-15 23:39
 */
interface CarRacingInterface {
    // interface는 묵지적으로 "abstract"가 포함되어있기에 불필요하다.
    List<Car> move();
}
