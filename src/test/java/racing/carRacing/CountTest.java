package racing.carRacing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CountTest {

    @Test
    @DisplayName("정상적인 숫자 입력 시 Count 변환")
    void rightNumberTest() {
        int test = 123;

        Count result = Count.createCount(test);

        assertThat(result).usingRecursiveComparison()
                .isEqualTo(new Count(123));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -100})
    @DisplayName("0보다 작은 숫자일 때 에러 반환")
    void negativeOrZeroNumberTest(int input) {
        assertThatThrownBy(
                () -> Count.createCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("List car 초기화 테스트")
    void initCarListTest() {
        Count numberOfCar = new Count(5);
        List<Car> cars = new ArrayList<>();

        List<Car> result = numberOfCar.initCars(cars);

        assertThat(result).hasSize(5);
    }

    @Test
    @DisplayName("count 회수 차감 테스트")
    void countDownTest() {
        Count numberOfCar = new Count(5);

        numberOfCar.countDown();

        assertThat(numberOfCar).usingRecursiveComparison()
                .isEqualTo(new Count(4));
    }

    @Test
    @DisplayName("count 가 0보다 클 때 통과 테스트")
    void isOverZeroTest() {
        Count numberOfCar = new Count(1);
        assertThat(numberOfCar.isOverZero()).isTrue();
    }

    @Test
    @DisplayName("count 가 0보다 작을 때 false 테스트")
    void isLessThanZeroTest() {
        Count numberOfCar = new Count(1);

        numberOfCar.countDown();

        assertThat(numberOfCar.isOverZero()).isFalse();
    }
}