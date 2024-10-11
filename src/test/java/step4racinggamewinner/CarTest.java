package step4racinggamewinner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step4racinggamewinner.random.RandomGenerator;
import step4racinggamewinner.random.TestRandomGenerator;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    static final int TEST_CAR_COUNT = 3;
    static final int DEFAULT_POSITION = 0;
    RandomGenerator randomGenerator;
    Cars cars;

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

    @Test
    void baseLineCar테스트() {
        String carNames = "red,kaki";
        cars = new Cars(carNames);
        assertThat(cars.baseLineCar().carName()).isEqualTo("red");
    }

    @Test
    void specificCarName테스트() {
        String carNames = "red,kaki";
        cars = new Cars(carNames);
        assertThat(cars.specificCarName(0)).isEqualTo("red");
    }

    @ParameterizedTest
    @CsvSource(value = {"3,0", "4,1"})
    void 이동여부_판단테스트(int randomNumber, int decisionResult) {
        cars = new Cars("red");
        assertThat(cars.decideGoStop(randomNumber)).isEqualTo(decisionResult);
    }


    @Test
    void 자동차별_한라운드_이동여부_저장() {
        randomGenerator = new TestRandomGenerator();
        cars = new Cars("red,blue");
        cars.recordEachRoundMoving(randomGenerator);
        assertThat(cars.currentCarPositionList())
                .isEqualTo(List.of(1, 1));
    }

    @Test
    void carNameAndPosition테스트() {
        cars = new Cars("red,blue");
        assertThat(cars.carNameAndPositions())
                .isEqualTo(Map.of("red", DEFAULT_POSITION, "blue", DEFAULT_POSITION));
    }

    @Test
    void currentCarPositionList테스트() {
        cars = new Cars("red,blue");
        assertThat(cars.currentCarPositionList())
                .isEqualTo(List.of(DEFAULT_POSITION, DEFAULT_POSITION));
    }


}
