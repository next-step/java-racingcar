package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarsTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        String[] carNames = {"pobi", "crong", "honux"};
        cars = new Cars(carNames);
    }

    @Test
    @DisplayName("생성된 자동차의 개수를 확인한다.")
    void initialize() {
        assertEquals(3, cars.getCars().size());
    }

    @Test
    @DisplayName("빈 자동차에서 우승자를 구하려는 경우 예외를 발생시킨다.")
    public void emptyCars() {
        Cars cars = new Cars(new String[]{});
        assertThatThrownBy(cars::getWinners)
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("최대 거리를 가진 우승자는 여러명이 있을 수 있다.")
    public void getWinners(){
        Cars cars = new Cars(new ArrayList<>(Arrays.asList(new Car(1, "pobi"), new Car(3, "crong"), new Car(3, "honux"))));
        assertThat(cars.getWinners().size()).isEqualTo(2);
    }
}