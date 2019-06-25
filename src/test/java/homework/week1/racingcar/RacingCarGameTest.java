package homework.week1.racingcar;

import homework.week1.racingcar.Car;
import homework.week1.racingcar.RacingCarGameEngine;
import homework.week1.racingcar.Winner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingCarGameTest {
        private RacingCarGameEngine carGameEngine;

    @BeforeEach
    void setUp() {
        carGameEngine = new RacingCarGameEngine("pobi,crong,honux", 5);
    }

    @Test
    void checkEmptyString_입력값빈문자입력시에러() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            carGameEngine.checkEmptyOrNull("");
        });
    }

    @Test
    void splitInput_문자열쉼표로자르기() {
        String[] carNames = carGameEngine.splitInput("qwe,asd,zxc");
        assertThat(carNames).containsExactly("qwe", "asd", "zxc");
    }
    
    @Test
    void positiveNumber_경주회수0이하숫자입력시에러() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            carGameEngine.checkInputPositiveNum(-1);
            carGameEngine.checkInputPositiveNum(0);
        });
    }

    @Test
    void move_move파라미터3일땐이동없음4일땐1이동() {
        Car car = new Car("pobi");
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void getWinnersName_우승자이름() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi", 3));
        cars.add(new Car("crong", 5));
        cars.add(new Car("honux", 5));
        Winner winner = new Winner();
        assertThat(winner.getWinnersName(cars)).containsExactly("crong", "honux");
    }
}
