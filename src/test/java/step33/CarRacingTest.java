package step33;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Random;


class CarRacingTest {

    private CarRacing carRacing;

    @BeforeEach
    void init() {
        carRacing = new CarRacing(1);
    }

    @DisplayName("CarRacing 횟수가 0회 일 경우 테스트")
    @Test
    void carResponsesIsEmptyTrue() {
        List<CarResponse> start = carRacing.start(new RandomGenerator(new Random()), 0);
        Assertions.assertEquals(start.isEmpty(), true);
    }

    @DisplayName("CarRacing 횟수가 1회 이상 일 경우 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9,10})
    void carResponsesIsEmptyFalse(int index) {
        List<CarResponse> start = carRacing.start(new RandomGenerator(new Random()), index);
        Assertions.assertEquals(start.isEmpty(), false);
    }

    @DisplayName("Random이 무조건 움직이는 번호일때 start 테스트")
    @Test
    void carStartMoveTest() {
        List<CarResponse> start = carRacing.start(new Go(new Random()), 1);
        Integer integer = start.get(0).getCarMoves().get(0);
        Assertions.assertEquals(integer, 1);
    }

    @DisplayName("Random이 무조건 안움직이는 번호일때 start 테스트")
    @Test
    void carStartStopTest() {
        List<CarResponse> start = carRacing.start(new Stop(new Random()), 1);
        Integer integer = start.get(0).getCarMoves().get(0);
        Assertions.assertEquals(integer, 0);
    }


}