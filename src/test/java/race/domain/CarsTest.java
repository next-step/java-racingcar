package race.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.number.DefaultNumberGenerator;
import utils.number.NumberGenerator;

class CarsTest {

    @Test
    void 요청한자동차댓수만큼만_자동차가_만들어진다() {
        // given
        int numberOfCar = 5;
        Cars cars = Cars.createInstance(numberOfCar);

        // when && then
        int expected = 5;
        assertThat(cars.getSize()).isEqualTo(expected);
    }

    @Test
    void 요청한이름으로_자동차가_만들어진다() {
        // Given
        String names = "pobi,crong,honux";

        // When
        Cars cars = Cars.createInstance(names);

        // Then
        int expected = 3;
        assertThat(cars.getSize()).isEqualTo(expected);
    }

    @Test
    void 이름이5글자가_초과하면_예외발생() {
        // Given
        String names = "default,pobi,crong";
        // When & Then
        assertThatThrownBy(() ->Car.createInstance(names))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 우승자를_선정() {
        // Given
        int stop = 0;
        int move = 4;
        Cars cars = Cars.createInstance("pobi,crong,honux");
        Car pobi = cars.getCars().get(0);
        Car crong = cars.getCars().get(1);
        Car honux = cars.getCars().get(2);

        // When
        pobi.move(stop);
        pobi.move(stop);
        pobi.move(move);

        crong.move(move);
        crong.move(move);
        crong.move(move);

        honux.move(stop);
        honux.move(stop);
        honux.move(stop);

        // Then
        List<Car> winners = cars.chooseWinners();
        int expected = 1;
        assertThat(winners.size()).isEqualTo(expected);
        assertThat(winners.get(0)).isEqualTo(crong);
    }

    @Test
    void 우승자는_여러명일수가_있다() {
        // Given
        int stop = 0;
        int move = 4;
        Cars cars = Cars.createInstance("pobi,crong,honux");
        Car pobi = cars.getCars().get(0);
        Car crong = cars.getCars().get(1);
        Car honux = cars.getCars().get(2);

        // When
        pobi.move(move);
        pobi.move(move);
        pobi.move(stop);

        crong.move(move);
        crong.move(move);
        crong.move(stop);

        honux.move(stop);
        honux.move(stop);
        honux.move(stop);

        // Then
        List<Car> winners = cars.chooseWinners();
        int expected = 2;
        assertThat(winners.size()).isEqualTo(expected);
        assertThat(winners).contains(pobi, crong);
    }

    @Test()
    void 자동차들은_사이상받으면_움직인다() {
        // Given
        int numberOfCar = 2;
        Cars cars = Cars.createInstance(numberOfCar);
        NumberGenerator four = new DefaultNumberGenerator(4);

        // When
        cars.moveCars(four);

        // Then
        for (Car car : cars.getCars()) {
            assertThat(car.getCountOfMove()).isEqualTo(1);
        }
    }

    @Test()
    void 자동차들은_사이상받으면_움직이고_3이하면_움직이지못한다() {
        // Given
        int numberOfCar = 2;
        int expected = 0;
        Cars cars = Cars.createInstance(numberOfCar);
        NumberGenerator three = new DefaultNumberGenerator(3);

        // When
        cars.moveCars(three);

        // Then
        for (Car car : cars.getCars()) {
            assertThat(car.getCountOfMove()).isEqualTo(expected);
        }
    }
}