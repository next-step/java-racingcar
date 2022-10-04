package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    private static final Cars cars = new Cars();

    @AfterEach
    void finish() {
        cars.clear();
    }

    @Test
    @DisplayName("add 메소드 실행 시, carList에 자동차가 한 대 추가된다.")
    void add() {
        cars.add();
        assertThat(cars.carList()).hasSize(1);
    }

    @Test
    @DisplayName("add 메소드에 int 타입의 인수를 넘긴 경우, carList에 입력한 수만큼 자동차가 추가된다.")
    void add_withNumberArgument() {
        cars.add(3);
        assertThat(cars.carList()).hasSize(3);
    }

    @Test
    @DisplayName("clear 메소드 실행 시, carList에 있던 모든 자동차들이 제거된다.")
    void clear() {
        cars.add(3);
        cars.clear();
        assertThat(cars.carList()).hasSize(0);
    }
}