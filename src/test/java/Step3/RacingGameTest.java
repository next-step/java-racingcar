package Step3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    RacingGame racingGame = new RacingGame();

    // params: carNum, playNum
    @ParameterizedTest
    @CsvSource({
            "3, 5",
            "5, 10",
            "1, 40"
    })
    void car_list_length_is_equal_to_car_num(int carNum, int playNum) {
        racingGame.makeBoard(carNum, playNum);

        assertThat(racingGame.getCars().size()).isEqualTo(carNum);
    }

    // params: carNum, playNum
    @ParameterizedTest
    @CsvSource({
            "3, 5",
            "5, 10",
            "1, 40"
    })
    void max_move_distance_is_not_greater_than_playNum(int carNum, int playNum) {
        racingGame.makeBoard(carNum, playNum);

        racingGame.play();

        List<RacingCar> cars = racingGame.getCars();

        int maxPosition = 0;
        for (RacingCar car : cars) {
            if(car.getPos() > maxPosition) {
                maxPosition = car.getPos();
            }
        }

        assertThat(maxPosition).isLessThanOrEqualTo(playNum);
    }
}
