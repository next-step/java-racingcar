package step3.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @ParameterizedTest
    @DisplayName("자동차가 움직여서 포지션이 맞는지 확인")
    @ValueSource(ints = {1, 2, 3})
    void getCarPosition(int moveCount) {
        Car car = new Car();
        Arrays.stream(new Integer[moveCount])
                .forEach(i -> car.move());
        assertThat(car.getCarPosition()).isEqualTo(moveCount);
    }

}