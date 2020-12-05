package com.nextstep.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private static final int CAR_COUNT = 5;

    private final CarName carName = new CarName("test");

    @DisplayName("자동차에 이름 부여")
    @Test
    public void name(){
        Car car = new Car(carName, () -> 1);
        assertThat(car.getName()).isEqualTo("test");
    }

    @DisplayName("현재 position과 파라미터로 입력받은 포지션이 같은지 확인")
    @ParameterizedTest
    @CsvSource({"3,3,true", "3,4,false"})
    public void equalsPosition(int moveCount, int maxPosition, boolean expected) {
        Car car = new Car(carName, () -> 5);
        for ( int ix = 0 ; ix < moveCount ; ix ++ ) {
            car.tryMove();
        }
        assertThat(car.equalsPosition(maxPosition)).isEqualTo(expected);
    }

    @DisplayName("move 호출 시 값에 따른 이동 여부 확인")
    @ParameterizedTest
    @MethodSource
    public void tryMove(Supplier<Integer> numberSupplier, int count) {
        Car car = new Car(carName, numberSupplier);
        for ( int ix = 0 ; ix < count ; ix ++ ) {
            car.tryMove();
        }
        assertThat(car.getPosition()).isEqualTo(count);
    }

    private static Stream<Arguments> tryMove() {
        Supplier<Integer> supplier1 = () -> 1;
        Supplier<Integer> supplier3 = () -> 3;
        Supplier<Integer> supplier4 = () -> 4;
        Supplier<Integer> supplier9 = () -> 9;

        return Stream.of(
                Arguments.of(supplier1, 0),
                Arguments.of(supplier3, 0),
                Arguments.of(supplier4, 1),
                Arguments.of(supplier9, 1)
        );
    }
}
