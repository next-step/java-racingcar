package step4racinggamewinner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    final static int TEST_CAR_COUNT = 3;
    RandomGenerator randomGenerator;
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

    @ParameterizedTest
    @CsvSource(value = {"3,false", "4,true"})
    void 이동여부_판단테스트(int randomNumber, boolean decisionResult) {
        String carNames = "red,kaki";
        int testRandomNumber = 4;
        cars = new Cars("red");
        assertThat(cars.decideGoStop(randomNumber)).isEqualTo(decisionResult);
    }


    @Test
    void 자동차별_한라운드_이동여부_저장() {
        String carNames = "red,kaki";
        int testRandomNumber = 4;
        randomGenerator = new TestRandomGenerator();
        cars = new Cars("red,blue");
        cars.recordEachRoundMoving(randomGenerator);
        assertThat(cars.currentCarPositionList())
                .isEqualTo(List.of(1, 1));
    }

    @Test
    void 우승자_찾기() {
        Car red = new Car("red", 4);
        Car kaki = new Car("kaki", 2);
        Car blue = new Car("blue", 4);
        cars = new Cars(List.of(red, kaki, blue));
        assertThat(cars.findWinner()).isEqualTo(List.of("red", "blue"));

    }


}
