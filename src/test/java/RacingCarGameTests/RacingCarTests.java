package RacingCarGameTests;

import domain.RacingCar;
import domain.RacingCars;
import domain.RacingRound;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;
import service.impl.RandomMoveRule;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@DisplayName("레이싱 카 테스트")
public class RacingCarTests {

    private static final String TEST_CAR_NAME = "testCar";

    @DisplayName("차 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"sonata", "sorento", "tesla"})
    public void generateCarTest(String carName) {
        assertThatCode(() -> RacingCar.newInstance(carName, new RandomMoveRule()))
                .doesNotThrowAnyException();
    }

    @DisplayName("차 이동 테스트")
    @ParameterizedTest(name = "랜덤 값 : {0} -> 결과 : {1}")
    @CsvSource({"0,0", "1,0", "2,0", "3,0", "4,1", "5,1", "6,1", "7,1", "8,1", "9,1"})
    @ExtendWith(MockitoExtension.class)
    public void moveCarTest(int randomValue, int expectedPosition) {
        Random random = mock(Random.class);
        given(random.nextInt(anyInt())).willReturn(randomValue);
        RacingCar racingCar = RacingCar.newInstance(TEST_CAR_NAME, new RandomMoveRule(random));

        assertThat(racingCar.move()).isEqualTo(expectedPosition);
    }

    @DisplayName("여러 차 이동 테스트")
    @ParameterizedTest
    @MethodSource("racingCarsTestCases")
    @ExtendWith(MockitoExtension.class)
    public void moveCarsTest(String[] carNames, int[] randomValues, RacingRound expectedRound) {
        List<RacingCar> cars = new ArrayList<>();
        for (int i = 0; i < randomValues.length; i++) {
            Random random = mock(Random.class);
            given(random.nextInt(anyInt())).willReturn(randomValues[i]);
            cars.add(RacingCar.newInstance(carNames[i], new RandomMoveRule(random)));
        }

        RacingCars racingCars = new RacingCars(cars);
        assertThat(racingCars.moveAll()).isEqualTo(expectedRound);
    }

    private static Stream<Arguments> racingCarsTestCases() {
        String[] testRacingCarNames = new String[]{"sonata", "sorento", "tesla"};
        return Stream.of(
                Arguments.of(testRacingCarNames, new int[]{9, 1, 4}, RacingRound.newInstance(new int[]{1, 0, 1})),
                Arguments.of(testRacingCarNames, new int[]{5, 5, 5, 5}, RacingRound.newInstance(new int[]{1, 1, 1, 1})),
                Arguments.of(testRacingCarNames, new int[]{1, 9, 2, 8, 4}, RacingRound.newInstance(new int[]{0, 1, 0, 1, 1}))
        );
    }

}
