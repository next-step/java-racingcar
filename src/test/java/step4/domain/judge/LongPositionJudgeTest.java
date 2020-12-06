package step4.domain.judge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step4.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongPositionJudgeTest {

    private static final String[] CARS = new String[]{"pobi", "jack", "honux"};
    private Judge judge;

    @BeforeEach
    void setUp() {
        judge = new LongPositionJudge();
    }

    @ParameterizedTest
    @MethodSource("generateCarsInfo")
    @DisplayName("우승자 점수를 판단하는 기능테스트")
    void judge(String[] carNames, int[] distance, int expected) {
        assertEquals(judge.judge(getCars(carNames, distance)), expected);
    }

    private List<Car> getCars(String[] carNames, int[] distance) {
        List<Car> cars = new ArrayList<>();
        for (int i=0; i< carNames.length; i++) {
            Car car = new Car(carNames[i]);
            for (int j=0; j<distance[i]; j++) {
                car.move(()->true);
            }
            cars.add(car);
        }
        return cars;
    }

    static Stream<Arguments> generateCarsInfo() {
        return Stream.of(
                Arguments.arguments(CARS, new int[]{1,3,5}, 5),
                Arguments.arguments(CARS, new int[]{1,5,5}, 5),
                Arguments.arguments(CARS, new int[]{5,7,7}, 7),
                Arguments.arguments(CARS, new int[]{8,8,8}, 8)
        );
    }

}