package edu.nextstep.racing.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-18 19:12
 */
class CarsTest {

    private List<String> carName;

    @BeforeEach
    void 사전설정() {
        carName = new ArrayList<>();
        carName.add("TEST1");
        carName.add("TEST2");
        carName.add("TEST3");

    }

    @Test
    void 리스트파라미터를통해_생성된_자동차그룹안_자동차들의_이름가져오기() {
        Cars cars = new Cars(carName);
        assertThat(cars.getCars.get(0).getCarName()).isEqualTo("TEST2");
    }

}