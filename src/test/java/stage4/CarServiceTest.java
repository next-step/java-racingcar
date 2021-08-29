package stage4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stage4.domain.Car;
import stage4.domain.CarName;
import stage4.domain.Cars;
import stage4.domain.Position;
import stage4.service.CarService;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class CarServiceTest {

    private final CarService carService = new CarService();

    @Test
    @DisplayName("우승자 선정 - 단일 결과 테스트")
    void checkWinnerTest() {
        // given
        final Car a = new Car(new CarName("a"), new Position(2));
        final Car b = new Car(new CarName("b"), new Position(3));
        final Car c = new Car(new CarName("c"), new Position(1));
        Cars lastResults = new Cars(Arrays.asList(a, b, c));
        Cars expectedResults = new Cars(Arrays.asList(b));

        // when
        final Cars winners = carService.checkWinner(lastResults);

        // then
        assertThat(winners).isEqualTo(expectedResults);
    }

    @Test
    @DisplayName("우승자 선정 - 복수 결과 테스트")
    void checkWinnersTest() {
        // given
        final Car a = new Car(new CarName("a"), new Position(3));
        final Car b = new Car(new CarName("b"), new Position(3));
        final Car c = new Car(new CarName("c"), new Position(1));
        Cars lastResults = new Cars(Arrays.asList(a, b, c));
        Cars expectedResults = new Cars(Arrays.asList(a, b));

        // when
        final Cars winners = carService.checkWinner(lastResults);

        // then
        assertThat(winners).isEqualTo(expectedResults);
    }
}
