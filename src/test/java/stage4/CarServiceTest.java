package stage4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stage4.domain.Car;
import stage4.domain.CarName;
import stage4.domain.Position;
import stage4.service.CarService;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarServiceTest {

    private final CarService carService = new CarService();

    @Test
    @DisplayName("우승자 선정 - 단일 결과 테스트")
    void checkWinnerTest() {
        // given
        List<Car> lastResults = Arrays.asList(
                new Car(new CarName("a"), new Position(2)),
                new Car(new CarName("b"), new Position(3)),
                new Car(new CarName("c"), new Position(1)));

        // when
        final List<Car> winners = carService.checkWinner(lastResults);

        // then
        assertThat(winners.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("우승자 선정 - 복수 결과 테스트")
    void checkWinnersTest() {
        // given
        List<Car> lastResults = Arrays.asList(
                new Car(new CarName("a"), new Position(3)),
                new Car(new CarName("b"), new Position(3)),
                new Car(new CarName("c"), new Position(1)));

        // when
        final List<Car> winners = carService.checkWinner(lastResults);

        // then
        assertThat(winners.size()).isEqualTo(2);
    }
}
