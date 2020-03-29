package step3;

import CarRacing.domain.*;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        final List<Car> carList =  Lists.newArrayList();
        carList.add(new Car("jinwoo", 3));
        carList.add(new Car("minho", 2));
        carList.add(new Car("charse",1));

        racingGame = new RacingGame(carList, 0);
    }


    @DisplayName("레이싱 게임의 우승자를 확인한다.")
    @Test
    void racingCarsRaceTest() {
        assertThat(racingGame.getRacingWinner().contains("jinwoo")).isTrue();
    }
}
