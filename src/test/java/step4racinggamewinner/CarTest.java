package step4racinggamewinner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    final static int TEST_CAR_COUNT = 3;

    Cars cars;

    @BeforeEach
    void init() {

    }

    @Test
    void 쉼표기준으로_자동차_생성() {
        String carNames = "red,kaki,blue";
        cars = new Cars(carNames);
        assertThat(cars.carCount()).isEqualTo(TEST_CAR_COUNT);
    }

    @Test
    void 차이름5글자_초과실패() {
        String carNames = "redeee,kaki";
        cars = new Cars();
        assertThatThrownBy(() -> {
                    cars.checkNameLength(List.of(carNames.split(",")));
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

}
