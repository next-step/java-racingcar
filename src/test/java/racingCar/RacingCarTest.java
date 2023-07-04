package racingCar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.Parser;
import racingcar.RaceUtil;
import racingcar.RandomUtil;

import java.util.stream.IntStream;

public class RacingCarTest {
    
    @Test
    void 랜덤값생성을요청했을때_성공() {
        // when
        int randomVal = RandomUtil.generate();

        // then
        assertThat(randomVal).isLessThanOrEqualTo(9);
        assertThat(randomVal).isGreaterThanOrEqualTo(0);
    }

    @Test
    void 자동차가멈추는범위의수가생성되면_정지성공() {
        // when & then
        IntStream.rangeClosed(0, 3).forEach(i -> {
            assertThat(RaceUtil.determineCarMovement(i)).isFalse();
        });

    }

    @Test
    void 자동차가전진하는범위의수가생성되면_전진성공() {
        // when & then
        IntStream.rangeClosed(4, 9).forEach(i -> {
            assertThat(RaceUtil.determineCarMovement(i)).isTrue();
        });
    }

    @Test
    void 올바른입력이주어질때_파싱성공() {
        // when
        String[] cars = Parser.parse("pobi,crong,honux");

        // then
        assertThat(cars).isEqualTo(new String[]{"pobi", "crong", "honux"});
    }

    @Test
    void 여섯자이상의이름이들어올때_파싱실패_RuntimeException발생() {
        // when & then
        assertThatThrownBy(() -> Parser.parse("pobiii,crong,honuxxx"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 자동차생성할때_성공() {
        // given
        String input = "pobi";
        Car car = Car.from(input);

        // when
        int position = car.getPosition();
        String name = car.getName();

        // then
        assertThat(position).isEqualTo(0);
        assertThat(name).isEqualTo(input);
    }

    @Test
    void 자동차전진요청할때_성공() {
        // given
        Car car = Car.from("hyun");
        int beforePosition = car.getPosition();

        // when
        car.moveForward();

        // then
        assertThat(car.getPosition()).isEqualTo(beforePosition + 1);
    }
}
