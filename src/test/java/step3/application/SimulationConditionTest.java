package step3.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static step3.application.SimulationCondition.ErrorMessage.*;

class SimulationConditionTest {
    @DisplayName("생성자")
    @Nested
    class constructor {
        @DisplayName("전달 된 '레이싱카'의 값이 1보다 작은 경우 'IllegalArgumentException'를 throw")
        @Test
        void throw_IllegalArgumentException_when_numberOfCar_not_more_then_one() {
            // given
            final int numberOfCar = 0;
            final int numberOfAttempts = 10;

            // when
            final Throwable thrown = catchThrowable(() -> {
                new SimulationCondition(numberOfCar, numberOfAttempts);
            });

            // then
            assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(NUMBER_OF_CAR_MUST_MORE_THEN_ONE.getMessage());
        }

        @DisplayName("전달 된 '시도할 회수'의 값이 1보다 작은 경우 'IllegalArgumentException'를 throw")
        @Test
        void throw_IllegalArgumentException_when_numberOfAttempts_not_more_then_one() {
            // given
            final int numberOfCar = 10;
            final int numberOfAttempts = 0;

            // when
            final Throwable thrown = catchThrowable(() -> {
                new SimulationCondition(numberOfCar, numberOfAttempts);
            });

            // then
            assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(NUMBER_OF_ATTEMPTS_MUST_MORE_THEN_ONE.getMessage());
        }

        @DisplayName("정상 생성")
        @Test
        void create() {
            // given
            final int numberOfCar = 1;
            final int numberOfAttempts = 1;

            // when
            final SimulationCondition result = new SimulationCondition(numberOfCar, numberOfAttempts);

            // then
            assertThat(result).isNotNull();
            assertThat(result.getNumberOfCar()).isEqualTo(numberOfCar);
            assertThat(result.getNumberOfAttempts()).isEqualTo(numberOfAttempts);
        }
    }
}