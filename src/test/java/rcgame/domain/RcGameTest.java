package rcgame.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import rcgame.dto.RcGameRequest;
import rcgame.util.TestNumberGenerator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.tuple;
import static rcgame.domain.RcCar.MOVE_BOUND_VALUE;

public class RcGameTest {

    TestNumberGenerator testNumberGenerator = new TestNumberGenerator();

    @Test
    public void 랜덤값이_4이상일_경우_모든_차는_전진한다() {
        //given
        RcGameRequest rcGameRequest = new RcGameRequest(new String[]{"test1", "test2"}, 3);

        RcGame rcGame = new RcGame(rcGameRequest);
        testNumberGenerator.setTestNumber(MOVE_BOUND_VALUE);

        //when
        List<RcCar> rcCars = rcGame.race(testNumberGenerator);

        //then
        Assertions.assertThat(rcCars)
                .extracting("name", "position")
                .containsSequence(tuple("test1", 1), tuple("test2", 1));
    }

    @Test
    public void 경기의_우승자를_조회한다() {
        //given
        List<RcCar> rcCars = Arrays.asList(
                new RcCar("test1", 3),
                new RcCar("test2", 2),
                new RcCar("test3", 3)
        );

        //when
        RcGame rcGame = new RcGame(rcCars);
        List<RcCar> winnerRcCars = rcGame.identifyWinner();

        //then
        Assertions.assertThat(winnerRcCars)
                .extracting("name")
                .containsSequence("test1", "test3");

    }
}