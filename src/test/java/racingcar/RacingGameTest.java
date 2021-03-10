package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.module.RacingGame;
import racingcar.module.GameManager;
import racingcar.util.ValidationUtil;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @DisplayName("게임 횟수 만큼 게임이 진행되는지 비교")
    @Test
    void startGame() {
        //GIVE

        Cars cars = new Cars(Arrays.asList(new Car[]{new Car(), new Car()}));
        RacingGame game = new RacingGame(cars);
        int total;

        //WHEN
        total = game.startGame(2);
        //THEN
        assertThat(total).isEqualTo(0);
    }




}
