package racing.winner;

import org.junit.jupiter.api.Test;
import racing.car.car.Car;
import racing.car.winner.Winner;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class WinnerTest {

    @Test
    void winner(){
        int max = 5;
        List<Car> cars = List.of(new Car("seou", 5), new Car("poi", 3));
        List<String> winnerInfo = Winner.getWinnerInfo(max, cars);

        assertThat(winnerInfo).contains("seou");
    }
}