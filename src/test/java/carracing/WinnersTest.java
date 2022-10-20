package carracing;

import carracing.domain.Car;
import carracing.domain.Cars;
import carracing.domain.Winners;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinnersTest {

    @Test
    void 자동차가_한대_이상이어야_위너체크가_가능하다() {
        String[] str = {};
        Cars cars = Cars.makeCars(str);

        assertThatThrownBy(() -> {
            new Winners(cars);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void Position이_큰_자동차List를_리턴(){

        Car a = new Car("A", 4);
        Car b = new Car("B", 2);
        Car c = new Car("B", 4);

        List<Car> carList = new ArrayList<>();
        carList.add(a);
        carList.add(b);
        carList.add(c);

        Cars cars = new Cars(carList);

        Winners winners = new Winners(cars);
        List<Car> winnerList = new ArrayList<>();
        winnerList.add(a);
        winnerList.add(c);

        assertThat(winners.findWinners()).isEqualTo(winnerList);
    }

    @Test
    void 우승자_구하기() {
        List<Car> cars = Arrays.asList(
                new Car("pobi",3),
                new Car("jason", 2)
        );
        List<Car> winners = Winners.findWinners(cars);
        assertThat(winners).contains(new Car("pobi",3));
    }
}
