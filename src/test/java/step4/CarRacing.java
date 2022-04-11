package step4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarRacing {

    @Test
    void 자동차가_4이상인_경우_전진한다() throws Exception {
        Car car = new Car("pobi");
        Assertions.assertThat(car.move(4)).isEqualTo("-");
    }

    @Test
    void 자동차가_4미만인_경우_멈춘다() throws Exception {
        Car car = new Car("pobi");
        Assertions.assertThat(car.move(2)).isEqualTo("");
    }

    @Test
    void 숫자는_0에서_9사이_값으로_나와야한다() {
        Matcher matcher = Pattern.compile("[0-9]").matcher(String.valueOf(Dice.roll()));
        Assertions.assertThat(matcher.find()).isTrue();
    }

    @Test
    void 자동차는_이름을_가진다() throws Exception {
        Car car = new Car("pobi");
        Assertions.assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    void 자동차_이름은_5자를_초과할_수_없다() throws Exception {
        Assertions.assertThatThrownBy(() -> new Car("pobiws")).isInstanceOf(Exception.class);
    }

    @Test
    void 자동차_이름을_같이_출력한다() throws Exception {
        Car car = new Car("pobi");
        car.move(4);
        Assertions.assertThat(car.getName() + " : " + car.getDistance()).isEqualTo("pobi : -");
    }

    @Test
    void 우승자는_한명_이상일_수_있다() throws Exception {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.add(new Car("crong"));
        cars.add(new Car("honux"));

        Racing racing = new Racing(cars);
        racing.play(5);
        List<Car> winners = racing.finish();

        Assertions.assertThat(winners.size()).isGreaterThan(0);
    }
}
