package racingcar.view;

import org.junit.jupiter.api.Test;
import racingcar.participant.Car;
import racingcar.participant.CarName;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ResultViewTest {

    @Test
    void 자동차_목록을_받아서_이동한_거리를_출력한다() {
        String actual = ResultView.printCarsDistance(List.of(new Car(new CarName("a")), new Car(new CarName("b")), new Car(new CarName("c"))));
        assertThat(actual).isEqualTo("a: \nb: \nc: \n");
    }
}