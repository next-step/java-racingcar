package car.domain;

import car.Car;
import car.CarName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RacingGameTest {

    List<Car> participants;
    RacingGame game;
    int condVal = 10;

    @BeforeEach
    void setUp() {
        game = new RacingGame();
        participants = new ArrayList<>();
        participants.add(new Car(new CarName("씽씽카"), 3));
        participants.add(new Car(new CarName("쏘카"), 1));
        participants.add(new Car(new CarName("그린카"), 5));
    }

    @Test
    void 자동차_전진횟수를_최댓값을_구한다() {
        // given
        int expected = 5;

        //when
        int actual = game.getMaxPosition(participants);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 자동차_경주_우승자를_구한다() {
        // given
        int moveCount = 5;

        // when
        List<Car> winners = game.getWinners(participants, moveCount);

        // then
        System.out.println("최종 우승자: " + winners);
        assertThat(winners).hasSize(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"씽씽카,소카,그린카:5"}, delimiter = ':')
    void 자동차_경주_게임을_시작한다(String carNames, int moveCount) {

        //given
        String[] cars = carNames.split(",");
        List<Car> participants = new ArrayList<>();

        for (String carName : cars) {
            participants.add(new Car(carName));
        }

        //when
        List<Car> winners = game.play(participants, moveCount);
        System.out.println("Winner: " + winners);
    }
}
