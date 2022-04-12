package racingcar;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import view.ResultView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RaceTest {
    @Test
    @Order(1)
    void 자동차_대수는_1대_이상이어야_한다() {
        assertThatThrownBy(() -> new Race(new ResultView()).start(0, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @Order(2)
    @ValueSource(ints = {3, 4, 5})
    void 주어진_횟수만큼_레이스가_진행된다(int tryCount) throws InterruptedException {
        int carCount = 3;
        ResultView resultView = new ResultView();
        assertThat(new Race(resultView).start(carCount, tryCount)).isEqualTo(tryCount);
    }

}