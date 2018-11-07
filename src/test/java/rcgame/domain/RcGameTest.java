package rcgame.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import rcgame.dto.RcGameRequest;
import rcgame.util.TestNumberGenerator;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.tuple;
import static rcgame.domain.RcCar.MOVE_BOUND_VALUE;

public class RcGameTest {

    TestNumberGenerator testNumberGenerator = new TestNumberGenerator();

    @Test
    public void 레이싱_테스트() {
        RcGameRequest rcGameRequest = new RcGameRequest(new String[]{"test1", "test2"}, 3);

        RcGame rcGame = new RcGame(rcGameRequest);
        testNumberGenerator.setTestNumber(MOVE_BOUND_VALUE);

        List<RcCar> rcCars = rcGame.race(testNumberGenerator);

        Assertions.assertThat(rcCars)
                .extracting("name", "position")
                .containsSequence(tuple("test1", 1), tuple("test2", 1));
    }
}