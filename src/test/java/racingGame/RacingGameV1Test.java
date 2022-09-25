package racingGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingGame.racingRule.FowardRule;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameV1Test {

    private FowardRule fowardRule = new FowardRule();

    @Test
    @DisplayName("차 대수 1, 시행 횟수 1를 입력하면 -를 list로 반환한다.")
    void racing_create_car_1_try_2() {
        //given
        InputParameters testInput = new InputParameters("1", "1");
        RacingGameV1 game_v1 = new RacingGameV1(testInput);

        Car testCar = new Car();
        testCar.move();
        //when
        List<Car> result = game_v1.play(fowardRule);
        //then
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0)).isIn(testCar);
    }

    @Test
    @DisplayName("차 대수 2, 시행 횟수 2를 입력하면 시행 횟수 만큼 -를 list로 반환한다.")
    void racing_create_car_1_try2() {
        //given
        InputParameters testInput = new InputParameters("2", "2");
        RacingGameV1 game_v1 = new RacingGameV1(testInput);
        Car testCar = new Car();
        Car testCar2 = new Car();
        testCar.move();
        testCar.move();
        testCar2.move();
        testCar2.move();
        //when
        List<Car> result = game_v1.play(fowardRule);
        //then
        assertThat(result).containsExactly(testCar,testCar2);
    }

}
