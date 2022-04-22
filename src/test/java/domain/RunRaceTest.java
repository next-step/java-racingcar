package domain;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RunRaceTest {
    @ParameterizedTest
    @Order(2)
    @ValueSource(ints = {3, 4, 5})
    void 주어진_횟수만큼_레이스가_진행된다(int tryCount) {
        assertThat(new RunRace().run("car,truck", tryCount)
                .getSize())
                .isEqualTo(tryCount);
    }
}