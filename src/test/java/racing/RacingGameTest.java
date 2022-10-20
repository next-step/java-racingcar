package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    @DisplayName("우승자 구하기")
    void winner() {
        List<Car> carList = new ArrayList<>();

        Car pobi = new Car("pobi");
        pobi.move(4);
        Car zeze = new Car("zeze");
        zeze.move(4);
        zeze.move(4);

        carList.add(pobi);
        carList.add(zeze);

        assertThat(RacingGame.getWinners(carList)).contains(zeze);
    }
    @Test
    @DisplayName("공동 우승자 구하기")
    void winners() {
        List<Car> carList = new ArrayList<>();

        Car pobi = new Car("pobi");
        pobi.move(4);
        pobi.move(4);
        Car zeze = new Car("zeze");
        zeze.move(4);
        zeze.move(4);

        carList.add(pobi);
        carList.add(zeze);
        carList.add(new Car("crong"));

        assertThat(RacingGame.getWinners(carList)).contains(pobi, zeze);
    }
}