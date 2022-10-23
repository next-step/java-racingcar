package carracing;

import calculator.Positive;
import carracing.domain.Car;
import carracing.domain.Cars;
import carracing.domain.WinnerChecker;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinnerCheckerTest {

    @Test
    void 자동차가_한대_이상이어야_위너체크가_가능하다() {
        String[] str = {};
        Cars cars = Cars.makeCars(str);

        assertThatThrownBy(() -> {
            new WinnerChecker(cars);
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

        WinnerChecker winnerChecker = new WinnerChecker(cars);
        List<Car> winnerList = new ArrayList<>();
        winnerList.add(a);
        winnerList.add(c);

        assertThat(winnerChecker.findWinners()).isEqualTo(winnerList);
    }
}
