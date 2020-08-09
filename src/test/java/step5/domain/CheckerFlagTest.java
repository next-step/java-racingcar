package step5.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CheckerFlagTest {
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = Car.ofCars("hojun,yame,yul");
    }

    @DisplayName("최종 우승자 성공")
    @ParameterizedTest
    @ValueSource(strings = {"hojun,yame,yul"})
    void showFinalChampion_success(String result) {
        assertThat(CheckerFlag.showFinalChampion(cars, 1)).isEqualTo(result);
    }


}