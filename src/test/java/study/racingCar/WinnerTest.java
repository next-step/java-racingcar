package study.racingCar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WinnerTest {

    private Winner winner;

    @BeforeEach
    void 초기화(){
        this.winner = new Winner();
    }

    @Test
    void 우승자차량찾기() {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new Car("jin"));
        cars.add(new Car("joo"));
        cars.get(1).move(6);
        assertThat(winner.findTheWinner(cars)).isEqualTo(new Car("joo"));
    }

    @Test
    void 공동우승자찾기테스트() {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new Car("jin"));
        cars.add(new Car("joo"));
        assertThat(winner.createWinners(cars, new Car())).asList()
                .isEqualTo(cars);
    }
}