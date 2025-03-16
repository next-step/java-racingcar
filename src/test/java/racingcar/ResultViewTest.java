package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ResultViewTest {

    @Test
    void 자동차_목록을_받아서_이동한_거리를_출력한다() {
        List<Car> cars = List.of(new Car(), new Car(), new Car());

        String actual = ResultView.printDistance(cars);
        assertThat(actual).isEqualTo("\n\n\n");
    }
}