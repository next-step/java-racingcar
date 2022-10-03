import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Random;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.RacingCar;

public class RacingCarTest {
    private final Random random = new Random();

    @ParameterizedTest
    @ValueSource(ints = {1,3,5,10,20})
    @DisplayName("클래스 초기화 테스트")
    public void initialize(int count) {
        RacingCar car = new RacingCar(random, count);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1,-10,100,200,300})
    @DisplayName("클래스 초기화 실패 케이스 테스트")
    public void initializeFailed(int count) {
        assertThatThrownBy(() -> {
            RacingCar car = new RacingCar(random, count);
        }).isInstanceOf(RuntimeException.class)
          .hasMessageContaining("count는 1에서 99까지의 숫자만 입력가능합니다.");

    }

    @ParameterizedTest
    @ValueSource(ints = {1,3,5,10,20})
    @DisplayName("getHistoryCount 메서드 테스트")
    public void getHistoryCount(int count) {
        RacingCar car = new RacingCar(random, count);
        assertThat(car.getHistoryCount()).isEqualTo(count);
    }

    @ParameterizedTest
    @MethodSource("getHistoriesByIndexTestParamsForSameCount")
    @DisplayName("getHistoriesByIndex 메서드 호출후 history 전체 원소가 셋팅되는지 테스트")
    public void getHistoriesByIndex_전체배열_체크(int count, int index) {
        RacingCar car = new RacingCar(random, count);
        assertThat(car.getHistoriesByIndex(index)).isIn(1, 0);
    }

    @ParameterizedTest
    @MethodSource("getHistoriesByIndexTestParams")
    @DisplayName("getHistoriesByIndex 메서드 테스트")
    public void getHistoriesByIndex(int count, int index) {
        RacingCar car = new RacingCar(random, count);
        assertThat(car.getHistoriesByIndex(index)).isInstanceOfAny(Integer.class);
    }

    @ParameterizedTest
    @MethodSource("getHistoriesByIndexTestParamsFailed")
    @DisplayName("getHistoriesByIndex 메서드 실패 케이스 테스트")
    public void getHistoriesByIndexFailed(int count, int index) {
        assertThatThrownBy(() -> {
            RacingCar car = new RacingCar(random, count);
            car.getHistoriesByIndex(index);
        }).isInstanceOf(RuntimeException.class)
          .hasMessageContaining("index 값이 올바르지 않습니다.");
    }

    private static Stream<Arguments> getHistoriesByIndexTestParams() {
        return Stream.of(
                Arguments.of(1, 0),
                Arguments.of(3, 2),
                Arguments.of(5, 3),
                Arguments.of(10, 5),
                Arguments.of(20, 19)
        );
    }

    private static Stream<Arguments> getHistoriesByIndexTestParamsFailed() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(3, 3),
                Arguments.of(5, 6),
                Arguments.of(10, 15),
                Arguments.of(20, 20)
        );
    }

    private static Stream<Arguments> getHistoriesByIndexTestParamsForSameCount() {
        return Stream.of(
                Arguments.of(5, 0),
                Arguments.of(5, 1),
                Arguments.of(5, 2),
                Arguments.of(5, 3),
                Arguments.of(5, 4)
        );
    }
}
