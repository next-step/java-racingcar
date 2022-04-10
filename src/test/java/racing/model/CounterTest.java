package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CounterTest {

    @DisplayName("count 객체 생성 동등성 테스트")
    @Test
    void counter() {
        assertThat(new Counter(0)).isEqualTo(new Counter(0));
    }

    @DisplayName("primitive 값으로 가져오는 getCount 테스트")
    @Test
    void getCount() {
        assertThat(new Counter(1).getCount()).isEqualTo(1);
    }

    @DisplayName("")
    @ParameterizedTest
    @CsvSource(value = {"0, 1, 1", "1, 2, 3"})
    void addTest(int init, int runStep, int expected) {
        Counter counter = new Counter(init);
        counter.add(runStep);
        assertThat(counter.getCount()).isEqualTo(expected);
    }
}