package edu.nextstep.racing.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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
    private List<String> exceptionCarName;

    @BeforeEach
    void 사전설정() {
        carName = new ArrayList<>();
        carName.add("TEST1");
        carName.add("TEST2");
        carName.add("TEST3");

        exceptionCarName = new ArrayList<>();
        exceptionCarName.add("EXCEP1");
        exceptionCarName.add("");
        exceptionCarName.add("EXCEP3");
    }

    @ParameterizedTest
    @ValueSource(strings = {"TEST1", "TEST2", "TEST3"})
    void 리스트파라미터를통해_생성된_자동차그룹안_자동차들의_이름가져오기(String nameList) {
        Cars cars = new Cars(carName);
        assertThat(cars.getCars().stream()
                .map(car -> car.getCarName())
                .collect(Collectors.toList()).contains(nameList)).isTrue();
    }

    @Test
    void 자동차그룹_객체_생성_예외상황() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Cars cars = new Cars(exceptionCarName);
        });
    }

}