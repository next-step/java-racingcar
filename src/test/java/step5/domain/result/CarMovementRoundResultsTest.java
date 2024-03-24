package step5.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import step3.domain.Car;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarMovementRoundResultsTest {

    @DisplayName("마지막 라운드 결과 반환 메서드는")
    @Nested
    class Describe_lastRoundResult {

        @DisplayName("라운드 결과가 없을 때,")
        @Nested
        class context_with_empty_list {

            @DisplayName("빈 Optional을 반환한다")
            @Test
            void it_returns_empty_optional() {
                final CarMovementRoundResults results = new CarMovementRoundResults();

                assertThat(results.lastRoundResult()).isEmpty();
            }
        }

        @DisplayName("라운드 결과가 존재할 때,")
        @Nested
        class context_with_round_results {

            @DisplayName("마지막 라운드의 결과를 반환한다")
            @Test
            void it_returns_last_index_element_from_list() {
                final CarMovementRoundResults results = new CarMovementRoundResults();
                final CarMovementRoundResult first = CarMovementRoundResult.from(
                        Collections.emptyList());

                final List<CarMovementResult> lastResult = List.of(new CarMovementResult("A", 3));
                final CarMovementRoundResult second = CarMovementRoundResult.from(lastResult);

                results.add(first);
                results.add(second);

                assertThat(results.lastRoundResult()).isNotEmpty()
                        .satisfies(resultOpt -> resultOpt.get().equals(lastResult));
            }
        }
    }

    @DisplayName("승자 이름 반환 메서드는")
    @Nested
    class Describe_winnerNames {

        @DisplayName("라운드 결과가 없을 때, 빈 배열을 반환한다.")
        @Test
        void it_returns_empty_list_when_empty_results() {
            final CarMovementRoundResults results = new CarMovementRoundResults();

            assertThat(results.winnerNames()).isEmpty();
        }

        @DisplayName("라운드 결과가 있을 때, 최종 승자의 이름을 반환한다.")
        @Test
        void it_returns_winner_names() {
            final CarMovementRoundResults results = new CarMovementRoundResults();
            final CarMovementRoundResult first = CarMovementRoundResult.from(
                    Collections.emptyList());

            final List<CarMovementResult> lastResult = List.of(new CarMovementResult("A", 3));
            final CarMovementRoundResult second = CarMovementRoundResult.from(lastResult);

            results.add(first);
            results.add(second);

            assertThat(results.winnerNames()).isNotEmpty()
                    .containsExactly("A");
        }
    }

}
