package edu.nextstep.racing.domain;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-22 14:17
 */
public class CarName {

    private String name;

    public CarName(String name) {
        nameValidation(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void nameValidation(String carName) {
        if(carName == null || "".equals(carName)) {
            throw new IllegalArgumentException("자동차 이름이 유효하지 않습니다.");
        }
    }
}
