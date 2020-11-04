package step3.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static step3.application.SimulationCondition.ErrorMessage.*;

class SimulationConditionTest {
    @DisplayName("of 생성자")
    @Nested
    class Of {
        @DisplayName("전달 된 '레이싱카'의 값이 1보다 작은 경우 'IllegalArgumentException'를 throw")
        @Test
        void throw_IllegalArgumentException_when_numberOfCar_not_more_then_one() {
            // given
            final String nameOfCars = "";
            final String numberOfAttempts = "10";

            // when
            final Throwable thrown = catchThrowable(() -> {
                SimulationCondition.of(nameOfCars, numberOfAttempts);
            });

            // then
            assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(NAME_OF_CARS_MUST_NOT_BE_BLANK.getMessage());
        }

        @DisplayName("전달 된 '시도할 회수'의 값이 1보다 작은 경우 'IllegalArgumentException'를 throw")
        @Test
        void throw_IllegalArgumentException_when_numberOfAttempts_not_more_then_one() {
            // given
            final String nameOfCars = "pobi,crong,honux";
            final String numberOfAttempts = "0";

            // when
            final Throwable thrown = catchThrowable(() -> {
                SimulationCondition.of(nameOfCars, numberOfAttempts);
            });

            // then
            assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(NUMBER_OF_ATTEMPTS_MUST_MORE_THEN_ONE.getMessage());
        }

        @DisplayName("전달 된 레이싱카 이름 리스트중에 길이가 5보다 큰 레이카가 존재하는 경우 'IllegalArgumentException'를 throw")
        @Test
        void throw_IllegalArgumentException_when_car_name_not_below_then_five() {
            // given
            final String nameOfCars = "abcdef";
            final String numberOfAttempts = "1";

            // when
            final Throwable thrown = catchThrowable(() -> {
                SimulationCondition.of(nameOfCars, numberOfAttempts);
            });

            // then
            assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(NAME_OF_CAR_LENGTH_MUST_BELOW_THEN_FIVE.getMessage());
        }

        @DisplayName("정상 생성")
        @Test
        void create() {
            // given
            final String nameOfCars = "pobi,crong,honux";
            final String numberOfAttempts = "10";

            // when
            final SimulationCondition result = SimulationCondition.of(nameOfCars, numberOfAttempts);

            // then
            assertThat(result).isNotNull();
            assertThat(result.getCarNames()).isEqualTo(Arrays.asList("pobi", "crong", "honux"));
            assertThat(result.getNumberOfAttempts()).isEqualTo(Integer.valueOf(numberOfAttempts));
        }
    }
}