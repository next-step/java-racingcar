package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.utils.Parser;
import racingcar.view.InputView;

public class GameTest {

    @DisplayName("이름 splitter가 적절하게 입력되었을 때는 플레이어를 정상적으로 인식")
    @Test
    void testNameSplitterValid() {
        assertThat(Parser.parseCarNames("A,B,C")) // Given & When
            .isEqualTo(Arrays.asList("A", "B", "C")); // Then
    }

    @DisplayName("각 플레이어별 이름이 (5자) 지정된 글자 수 이내일 경우 통과하며, 그렇지 않을 경우 IllegalArgumentException을 발생")
    @Test
    void testNameLengthValid() {
        // Given
        List<String> carNames = Parser.parseCarNames("OK,Invalid,A_Car");

        // When
        assertThatThrownBy(() -> new Cars(carNames.stream()
            .map(Car::new)
            .collect(Collectors.toList())
        ))
            // Then
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("A가 3칸 움직일 때, 예상한대로 움직였는지 확인한다. (멤버 변수 distance = 3인지 여부 확인)")
    @Test
    void testCarRunnable() {
        // Given
        Car carA = new Car("A");
        List<Boolean> moves = Arrays.asList(true, false, true, false, true);
        int moved = 3;

        // When
        TestUtils.carMove(carA, moves);

        // Then
        assertThat(carA.distance())
            .isEqualTo(moved);
    }

    @DisplayName("3칸 이동하는 A와 2칸 이동하는 B가 주어졌을 때, 우승자를 필터링하면 A가 필터된다.")
    @Test
    void testCarDistancePrintingValid() {
        // Given
        List<Boolean> aMoves = Arrays.asList(true, false, true, false, true);
        List<Boolean> bMoves = Arrays.asList(false, false, true, false, true);

        Car a = new Car("A");
        Car b = new Car("B");

        TestUtils.carMove(a, aMoves);
        TestUtils.carMove(b, bMoves);

        Cars cars = new Cars(Arrays.asList(a, b));

        // Then
        assertThat(cars.filterWinners())
            .isEqualTo(Arrays.asList(a));
    }

}
