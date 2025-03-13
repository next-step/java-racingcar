package racing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RacingCarTest {

    @Test
    @DisplayName("입력받은 수만큼 자동차 생성")
    void 자동차_생성() {
        assertThat(RacingCar.createCars(5)).hasSize(5);
    }

    @Test
    @DisplayName("입력받은 수만큼 턴 행동")
    void 턴_행동() {
        List<Car> cars = List.of(new Car(), new Car());

        List<List<Integer>> positions = RacingCar.activeTurns(cars, 5);

        assertThat(positions).hasSize(5);
        for (List<Integer> position : positions) {
            assertThat(position).hasSize(2);
        }
    }

    @Test
    @DisplayName("각 자동차 행동")
    void 자동차_행동() {
        List<Car> cars = List.of(new Car(), new Car(), new Car());

        List<Integer> positions = RacingCar.activeCars(cars);

        assertThat(positions).hasSize(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:false", "1:false", "2:false", "3:false", "4:true", "5:true",
            "6:true", "7:true", "8:true", "9:true"}, delimiter = ':')
    void 전진_조건(int randomNumber, boolean canMove) {
        assertThat(RacingCar.canProgress(randomNumber)).isEqualTo(canMove);
    }

}
