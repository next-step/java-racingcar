package step33;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


class CarRacingTest {

    private CarRacing carRacing;

    @BeforeEach
    void init() {
        List<Car> cars = IntStream.range(0, 1)
                .mapToObj(amount -> new Car())
                .collect(Collectors.toList());

        carRacing = new CarRacing(cars);
    }

    @DisplayName("CarRacing 횟수가 0회 일 경우 테스트")
    @Test
    void CarResponsesIsEmptyTrue() {
        List<CarResponse> start = carRacing.start(new RandomGenerator(new Random()), 0);
        Assertions.assertEquals(start.isEmpty(), true);
    }

    @DisplayName("CarRacing 횟수가 1회 이상 일 경우 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9,10})
    void CarResponsesIsEmptyFalse(int index) {
        List<CarResponse> start = carRacing.start(new RandomGenerator(new Random()), index);
        Assertions.assertEquals(start.isEmpty(), false);
    }


}