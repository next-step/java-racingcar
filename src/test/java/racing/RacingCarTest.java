package racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.times;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class RacingCarTest {

    @Test
    @DisplayName("입력받은 수만큼 자동차 생성")
    void 자동차_생성() {
        assertThat(RacingCar.createCars(5)).hasSize(5);
    }


    @Test
    @DisplayName("입력받은 수만큼 자동차 행동")
    void 자동차_행동() {
        try (MockedStatic<RacingCar> mocked = Mockito.mockStatic(RacingCar.class,
                CALLS_REAL_METHODS)) {
            List<Car> cars = List.of(new Car(), new Car());
            mocked.when(() -> RacingCar.activeCars(any())).thenAnswer(invocation -> {
                return null;
            });

            RacingCar.activeTurns(cars, 5);

            mocked.verify(() -> RacingCar.activeCars(any()), times(5));
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"0:false", "1:false", "2:false", "3:false", "4:true", "5:true",
            "6:true", "7:true", "8:true", "9:true"}, delimiter = ':')
    void 전진_조건(int randomNumber, boolean canMove) {
        assertThat(RacingCar.canProgress(randomNumber)).isEqualTo(canMove);
    }

}
