package edu.nextstep.camp.racing.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CarsTest {

    private Cars cars;

    @BeforeEach
    void init() {
        cars = new Cars("TEST1", "TEST2") {
            @Override
            protected int randomInt() {
                return 4;
            }
        };
    }


    @Test
    void 자동차_움직임_랜덤값_삽입(){
        cars.moveCars();

        assertThat(cars.toString())
                .isEqualTo("TEST1 : -\nTEST2 : -");
    }

    @Test
    void 우승자_테스트() {
        cars.moveCars();
        List<String> winners = cars.winners();

        assertThat(winners)
                .contains("TEST1", "TEST2");
    }

    @Test
    void 운전자_이름_중복_검증() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Cars("TEST", "TEST"))
                .isInstanceOf(IllegalArgumentException.class)
                .withMessageContaining("중복될 수 없습니다.");
    }

    @ParameterizedTest
    @MethodSource("carCountValidParams")
    void 자동차_대수_검증(String cars) {
        assertAll(
                () -> assertThatIllegalArgumentException().isThrownBy(() -> new Cars(cars)),
                () -> assertThatIllegalArgumentException().isThrownBy(() -> new Cars("test")));
    }

    private static Stream<String> carCountValidParams() {
        return Stream.of("RIDER", carsString(21));
    }

    private static String carsString(int carsCount) {
        if (carsCount <= 0) {
            throw new IllegalArgumentException("1 이상 입력 하세요");
        }

        List<String> charSequences = new ArrayList<>();

        for (int i = 0; i < carsCount; i++) {
            charSequences.add("C" + i);
        }

        return String.join(",", charSequences);
    }

}
