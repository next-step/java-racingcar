package Step3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    // params: carNum, playNum
    @ParameterizedTest
    @CsvSource({
            "3, 5",
            "5, 10",
            "1, 40"
    })
    void car_list_length_is_equal_to_car_num(int carNum, int playNum) {
        String[] carNames = genTestCarNames(carNum);

        RacingGame racingGame = new RacingGame(carNames, playNum);

        assertThat(racingGame.getCars().length).isEqualTo(carNum);
    }

    // params: carNum, playNum
    @ParameterizedTest
    @CsvSource({
            "3, 5",
            "5, 10",
            "1, 40"
    })
    void max_move_distance_is_not_greater_than_playNum(int carNum, int playNum) {
        String[] carNames = genTestCarNames(carNum);

        RacingGame racingGame = new RacingGame(carNames, playNum);
        int[][] playRands = RandGenerator.genPlayRands(carNum, playNum);

        try {
            racingGame.play(playRands);
        } catch (Exception e) {
            // nothing
        }

        RacingCar[] cars = racingGame.getCars();

        int maxPosition = 0;
        for (RacingCar car : cars) {
            if(car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        assertThat(maxPosition).isLessThanOrEqualTo(playNum);
    }

    // params: carNum, playNum
    @ParameterizedTest
    @CsvSource({
            "3, 5",
            "5, 10",
            "1, 40"
    })
    void car_always_move(int carNum, int playNum) {
        int[][] playRands = genTestPlayRands(playNum, carNum, 9);

        String[] carNames = genTestCarNames(carNum);

        RacingGame racingGame = new RacingGame(carNames, playNum);

        try {
            racingGame.play(playRands);
        } catch (Exception e) {
            // nothing
        }

        List<RacingCar> winners = racingGame.getWinner();

        assertThat(winners).hasSize(carNum);
        assertThat(winners.get(0).getPosition()).isEqualTo(playNum);
    }

    private static String[] genTestCarNames(int carNum) {
        String[] carNames = new String[carNum];
        for (int i = 0; i < carNum; i++) {
            carNames[i] = "Car " + i;
        }
        return carNames;
    }

    // params: carNum, playNum
    @ParameterizedTest
    @CsvSource({
            "3, 5",
            "5, 10",
            "1, 40"
    })
    void car_always_not_move(int carNum, int playNum) {
        int[][] playRands = genTestPlayRands(playNum, carNum, 0);

        String[] carNames = genTestCarNames(carNum);

        RacingGame racingGame = new RacingGame(carNames, playNum);
        try {
            racingGame.play(playRands);
        } catch (Exception e) {
            // nothing
        }

        List<RacingCar> winners = racingGame.getWinner();

        assertThat(winners).hasSize(carNum);
        assertThat(winners.get(0).getPosition()).isEqualTo(0);
    }

    private static int[][] genTestPlayRands(int playNum, int carNum, int rand) {
        int[][] playRands = new int[playNum][carNum];

        for (int i = 0; i < playNum; i++) {
            for (int j = 0; j < carNum; j++) {
                playRands[i][j] = rand;
            }
        }
        return playRands;
    }
}
