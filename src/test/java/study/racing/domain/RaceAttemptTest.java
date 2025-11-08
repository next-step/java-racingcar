package study.racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RaceAttemptTest {

    @Test
    @DisplayName("차량 수만큼 빈 문자열로 초기화된 결과 리스트를 생성한다")
    void createResultsListWithEmptyStrings() {
        assertThat(new RaceAttempt(3).getResults()).hasSize(3);
        assertThat(new RaceAttempt(3).getResults()).containsExactly("", "", "");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 10})
    @DisplayName("다양한 차량 수로 결과 리스트를 생성할 수 있다")
    void createResultsListWithVariousCarCounts(int numberOfCars) {
        assertThat(new RaceAttempt(numberOfCars).getResults()).hasSize(numberOfCars);
        assertThat(new RaceAttempt(numberOfCars).getResults()).allMatch(String::isEmpty);
    }

    @Test
    @DisplayName("차량이 1대일 때 결과 리스트가 정상적으로 생성된다")
    void createResultsListWithOneCar() {
        assertThat(new RaceAttempt(1).getResults()).hasSize(1);
        assertThat(new RaceAttempt(1).getResults().get(0)).isEmpty();
    }

    @Test
    @DisplayName("생성된 결과 리스트의 모든 요소가 빈 문자열이다")
    void allResultsAreEmptyStrings() {
        for (String result : new RaceAttempt(5).getResults()) {
            assertThat(result).isEqualTo("");
            assertThat(result).isEmpty();
        }
    }

    @Test
    @DisplayName("결과 리스트는 수정 가능한 리스트이다")
    void resultsListIsModifiable() {
        new RaceAttempt(2).getResults().set(0, "-");
        new RaceAttempt(2).getResults().set(1, "--");

        assertThat(new RaceAttempt(2).getResults().get(0)).isEqualTo("");
        assertThat(new RaceAttempt(2).getResults().get(1)).isEqualTo("");
    }

    @Test
    @DisplayName("getResults()는 동일한 리스트 인스턴스를 반환한다")
    void getResultsReturnsSameInstance() {
        assertThat(new RaceAttempt(3).getResults()).isSameAs(new RaceAttempt(3).getResults());
    }

    @Test
    @DisplayName("initRaceAttempt 메서드는 차량 수만큼의 빈 문자열 리스트를 반환한다")
    void initRaceAttemptReturnsEmptyStringList() {
        assertThat(new RaceAttempt(3).initRaceAttempt(4)).hasSize(4);
        assertThat(new RaceAttempt(3).initRaceAttempt(4)).containsExactly("", "", "", "");
    }

    @Test
    @DisplayName("차량 수가 0일 때 빈 리스트가 생성된다")
    void createEmptyListWhenZeroCars() {
        assertThat(new RaceAttempt(0).getResults()).isEmpty();
        assertThat(new RaceAttempt(0).getResults()).hasSize(0);
    }

    @Test
    @DisplayName("많은 수의 차량으로도 결과 리스트를 생성할 수 있다")
    void createResultsListWithManyCars() {
        assertThat(new RaceAttempt(100).getResults()).hasSize(100);
        assertThat(new RaceAttempt(100).getResults()).allMatch(String::isEmpty);
    }

    @Test
    @DisplayName("결과 리스트는 ArrayList 타입이다")
    void resultsListIsArrayList() {
        assertThat(new RaceAttempt(3).getResults()).isInstanceOf(java.util.ArrayList.class);
    }

}