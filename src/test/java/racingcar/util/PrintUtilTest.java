package racingcar.util;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.wrapper.ForwardStatus;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class PrintUtilTest {
    @Test
    void 한번_이동_결과를_문자열로_출력한다() {
        // given
        Cars cars = new Cars(List.of(new Car(), new Car(), new Car()));
        String expected = "-----\n-----\n-----\n\n";
        IntStream.range(0, 5).forEach(index -> cars.moveAllByNumberCreator(() -> new ForwardStatus(4)));
        // when
        String actual = PrintUtil.result(cars);
        // then
        assertThat(actual).isEqualTo(expected);
    }

}
