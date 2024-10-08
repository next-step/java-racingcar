package racing.winner;

import org.junit.jupiter.api.Test;
import racing.car.car.Car;
import racing.car.car.Cars;
import racing.car.winner.Winner;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class WinnerTest {

    @Test
    void winner(){
        int max = 5;
        Cars cars = new Cars(List.of(new Car("seou", 5), new Car("poi", 3)));
        List<Car> winnerInfo = Winner.getWinnerInfo(max, cars);

        assertThat(winnerInfo).contains((new Car("seou", 5)));
    }
}