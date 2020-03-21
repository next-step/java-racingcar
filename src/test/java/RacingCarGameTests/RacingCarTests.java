package RacingCarGameTests;

import domain.RacingCar;
import domain.RacingCars;
import domain.RacingRound;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
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

    @DisplayName("차 생성 테스트")
    @Test
    public void generateCarTest() {
        assertThatCode(() -> RacingCar.newInstance(new RandomMoveRule()))
                .doesNotThrowAnyException();
    }

    @DisplayName("차 이동 테스트")
    @ParameterizedTest(name = "랜덤 값 : {0} -> 결과 : {1}")
    @CsvSource({"0,0", "1,0", "2,0", "3,0", "4,1", "5,1", "6,1", "7,1", "8,1", "9,1"})
    @ExtendWith(MockitoExtension.class)
    public void moveCarTest(int randomValue, int expectedPosition) {
        Random random = mock(Random.class);
        given(random.nextInt(anyInt())).willReturn(randomValue);
        RacingCar racingCar = RacingCar.newInstance(new RandomMoveRule(random));
        assertThat(racingCar.move()).isEqualTo(expectedPosition);
    }

    @DisplayName("여러 차 이동 테스트")
    @ParameterizedTest
    @MethodSource("racingCarsTestCases")
    @ExtendWith(MockitoExtension.class)
    public void moveCarsTest(int[] randomValues, RacingRound expectedRound) {
        List<RacingCar> cars = new ArrayList<>();
        for (int randomValue : randomValues) {
            Random random = mock(Random.class);
            given(random.nextInt(anyInt())).willReturn(randomValue);
            cars.add(RacingCar.newInstance(new RandomMoveRule(random)));
        }

        RacingCars racingCars = new RacingCars(cars);
        assertThat(racingCars.moveAll()).isEqualTo(expectedRound);
    }

    private static Stream<Arguments> racingCarsTestCases() {
        return Stream.of(
                Arguments.of(new int[]{9, 1, 4}, RacingRound.newInstance(new int[]{1, 0, 1})),
                Arguments.of(new int[]{5, 5, 5, 5}, RacingRound.newInstance(new int[]{1, 1, 1, 1})),
                Arguments.of(new int[]{1, 9, 2, 8, 4}, RacingRound.newInstance(new int[]{0, 1, 0, 1, 1}))
        );
    }

}
