package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ResultViewTest {

    @Test
    void 자동차_목록을_받아서_이동한_거리를_출력한다() {
        String actual = ResultView.printCarsDistance(List.of(new Car("a"), new Car("a"), new Car("b")));
        assertThat(actual).isEqualTo("\n\n\n");
    }
}