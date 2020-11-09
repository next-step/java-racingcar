package step5.client.worker.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static step5.client.worker.domain.RacingGameCondition.ErrorMessage.*;

class RacingGameConditionTest {
    @DisplayName("of 생성자")
    @Nested
    class Of {
        @DisplayName("전달 된 '시도할 회수'의 값이 1보다 작은 경우 'IllegalArgumentException'를 throw")
        @Test
        void throw_IllegalArgumentException_when_number_of_attempts_not_more_then_one() {
            // given
            final String carNames = "pobi,crong,honux";
            final String numberAttempts = "0";

            // when
            final Throwable thrown = catchThrowable(() -> {
                RacingGameCondition.of(carNames, numberAttempts);
            });

            // then
            assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(NUMBER_OF_ATTEMPTS_MUST_MORE_THEN_ONE.getMessage());
        }

        @DisplayName("전달 된 레이싱카 이름 리스트중에 중복된 이름이 존재하는 경우 'IllegalArgumentException'를 throw")
        @Test
        void throw_IllegalArgumentException_when_car_name_be_duplicated() {
            // given
            final String carNames = "a,b,c,d,a";
            final String numberAttempts = "1";

            // when
            final Throwable thrown = catchThrowable(() -> {
                RacingGameCondition.of(carNames, numberAttempts);
            });

            // then
            assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(CAR_NAME_MUST_NOT_BE_DUPLICATED.getMessage());
        }

        @DisplayName("정상 생성")
        @Test
        void create() {
            // given
            final String carNamesExpression = "pobi,crong,honux";
            final String numberAttempts = "10";
            final List<CarName> carNames = Arrays.asList(CarName.of("pobi"), CarName.of("crong"), CarName.of("honux"));

            // when
            final RacingGameCondition result = RacingGameCondition.of(carNamesExpression, numberAttempts);

            // then
            assertThat(result).isNotNull();
            assertThat(result.getCarNames()).isEqualTo(carNames);
            assertThat(result.getTryNumber()).isEqualTo(Integer.valueOf(numberAttempts));
        }
    }
}