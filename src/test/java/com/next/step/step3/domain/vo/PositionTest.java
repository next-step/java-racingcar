package com.next.step.step3.domain.vo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @ParameterizedTest(name = "move 호출 시 1만 증가하는지 확인하는 테스트")
    @MethodSource("providePosition")
    void move_호출_시_1씩_증가(Position position, int expected) {
        Position result = position.move();
        assertThat(result.position()).isEqualTo(expected);
    }

    static Stream<Arguments> providePosition() {
        return Stream.of(
                Arguments.of(new Position(0), 1),
                Arguments.of(new Position(1), 2),
                Arguments.of(new Position(2), 3)
        );
    }
}
