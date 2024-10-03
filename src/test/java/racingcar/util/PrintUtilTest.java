package racingcar.util;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Winner;
import racingcar.model.enums.Status;
import racingcar.model.wrapper.CarName;
import racingcar.model.wrapper.ForwardStatus;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.model.enums.Status.FORWARD;
import static racingcar.model.enums.Status.STOP;
import static racingcar.model.fixture.CarsFixture.*;

public class PrintUtilTest {
    @Test
    void 한번_이동_결과를_문자열로_출력한다() {
        // given
        Car car1 = new Car(carName1);
        Car car2 = new Car(carName2);
        Car car3 = new Car(carName3);
        Cars cars = new Cars(List.of(car1, car2, car3));
        String expected = "name1 : -----\nname2 : -----\nname3 : -----\n\n";
        IntStream.range(0, 5).forEach(index -> cars.moveAllByNumberCreator(() -> new ForwardStatus(4)));
        // when
        String actual = PrintUtil.result(cars);
        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 우승한_자동차들을_출력한다() {
        Car car1 = new Car(carName1, List.of(FORWARD, FORWARD, STOP, FORWARD));
        Car car2 = new Car(carName2, List.of(STOP,STOP,STOP,STOP));
        Car car3 = new Car(carName3, List.of(FORWARD,FORWARD,STOP,FORWARD));
        Cars cars = new Cars(List.of(car1, car2, car3));
        String expected = "name1, name3가 최종 우승했습니다.";

        String actual = PrintUtil.winner(new Winner(cars));

        assertThat(actual).isEqualTo(expected);
    }
}
