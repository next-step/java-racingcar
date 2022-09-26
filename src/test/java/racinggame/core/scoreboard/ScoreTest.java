package racinggame.core.scoreboard;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.core.car.Car;
import racinggame.core.car.Cars;
import racinggame.exception.InvalidUnknownCarNameException;

class ScoreTest {

    private static final int ENOUGH_FUEL = 9;
    private static final int NOT_ENOUGH_FUEL = 1;

    @Test
    @DisplayName("라운드 스코어 기록.")
    void get_scores_of_round() {
        Score score = new Score();
        score.recordScore(getDefaultCars());

        assertThat(score.getAllScore()).hasSize(3);
    }

    @Test
    @DisplayName("존재하는 차량의 라운드 스코어 조회.")
    void get_score() {
        Score score = getDefaultScore();
        assertThat(score.getScore("A")).isEqualTo(1);
    }

    @Test
    @DisplayName("존재하지 않는 차량의 라운드 스코어 조회시 예외 발생.")
    void fail_to_get_score_of_invalid_car_name() {
        Score score = getDefaultScore();
        assertThatThrownBy(() -> score.getScore("D"))
                .isInstanceOf(InvalidUnknownCarNameException.class);
    }

    @Test
    @DisplayName("라운드 우승자 확인.")
    void get_winner() {
        Score score = getDefaultScore();
        List<String> winners = score.getWinner();

        assertAll(
                () -> assertThat(winners).contains("A"),
                () -> assertThat(winners).doesNotContain("B"),
                () -> assertThat(winners).contains("C")
        );
    }

    private Score getDefaultScore() {
        Score score = new Score();
        score.recordScore(getDefaultCars());
        return score;
    }

    private Cars getDefaultCars() {
        List<Car> carList = List.of(new Car("A"), new Car("B"), new Car("C"));
        carList.get(0).move(ENOUGH_FUEL);
        carList.get(1).move(NOT_ENOUGH_FUEL);
        carList.get(2).move(ENOUGH_FUEL);

        return new Cars(carList);
    }
}