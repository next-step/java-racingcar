package com.nextstep.racingcar.domain;

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
    private final static String CAR_NAME = "test";
    private final static String DASH = "-";

    @DisplayName("자동차에 이름 부여")
    @Test
    public void name(){
        Car car = new Car(new CarName(CAR_NAME), () -> 1);
        assertThat(car.toString()).isEqualTo("test");
    }

    private Car createMovedCar(int moveCount) {
        return createMovedCar(CAR_NAME, moveCount);
    }

    private Car createMovedCar(String name, int moveCount) {
        Car car = new Car(new CarName(name), () -> 5);
        for ( int ix = 0 ; ix < moveCount ; ix ++ ) {
            car.tryMove();
        }
        return car;
    }

    @DisplayName("서로 다른 Car의 포지션이 같은지 확인")
    @ParameterizedTest
    @CsvSource({"3,3,true", "3,4,false"})
    public void equalsPosition(int moveCount, int otherMoveCount, boolean expected) {
        Car car = createMovedCar(moveCount);
        Car car2 = createMovedCar(otherMoveCount);

        assertThat(car.equalsPosition(car2)).isEqualTo(expected);
    }

    @DisplayName("move 호출 시 값에 따른 이동 여부 확인")
    @ParameterizedTest
    @MethodSource
    public void tryMove(Supplier<Integer> numberSupplier, int moveCount, int otherMoveCount) {
        Car car = new Car(new CarName(CAR_NAME), numberSupplier);
        for ( int ix = 0 ; ix < moveCount ; ix ++ ) {
            car.tryMove();
        }
        Car car2 = createMovedCar(otherMoveCount);
        assertThat(car.equalsPosition(car2)).isTrue();
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

    @DisplayName("position이 더 큰 Car 반환 테스트")
    @ParameterizedTest
    @CsvSource({"test1, 3, test2, 5, test2", "test1, 5, test2, 1, test1"})
    public void getWinner(String name, int moveCount, String name2, int moveCount2, String expected) {
        Car car1 = createMovedCar(name, moveCount);
        Car car2 = createMovedCar(name2, moveCount2);

        Car winner = car1.compareAndGet(car2);
        assertThat(winner.toString()).isEqualTo(expected);
    }

    @DisplayName("현재 position에 맞는 CarRecord 정보가 나오는지 확인")
    @ParameterizedTest
    @CsvSource({"1, 1", "3, 3"})
    public void record(int moveCount, int expected) {
        Car car = createMovedCar(moveCount);
        CarRecord record = car.record();
        assertThat(record.getPosition()).isEqualTo(expected);
    }
}
