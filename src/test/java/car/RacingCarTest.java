package car;
import car.Car;
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

public class RacingCarTest {
    List<Car> participants;
    RacingCar game;
    int condVal = 10;

    @BeforeEach
    void setUp() {
        game = new RacingCar();
        participants = new ArrayList<>();
        participants.add(new Car("씽씽카", 3));
        participants.add(new Car("쏘카", 1));
        participants.add(new Car("그린카", 5));
        for (int i = 0; i < participants.size(); i++) {
            System.out.println(participants.get(i).getName());
        }
    }


    @Test
    void 자동차_전진횟수를_최댓값을_구한다() {
        // given
        int expected = 5;

        //when
        int actual = game.getMaxPosition(participants);

        // then
        assertThat(actual).isEqualTo(expected);
        System.out.println(actual);
    }

    @Test
    void 자동차_경주_우승자를_구한다() {
        // given
        int moveCount = 5;

        // when
        List<Car> winners = game.getWinners(participants, moveCount);
        System.out.println(winners.get(0).getName());
        //String winnerName = winners.participants ;

        // then
        //System.out.println("최종 우승자: " + winners);
        assertThat(winners).hasSize(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"씽씽카,소카,그린카:5"}, delimiter = ':')
    void 자동차_경주_게임을_시작한다(String carNames, int moveCount) {

        //given
        String[] cars = carNames.split(",");
        List<Car> participants = new ArrayList<>();

        for (String carName : cars) {
            participants.add(new Car(carName,0));
        }

        //when
        List<Car> winners = game.play(participants, moveCount);
        for (int i = 0; i < winners.size(); i++) {
            System.out.println("Winner: " + winners.get(i).getName());
        }
    }
}
