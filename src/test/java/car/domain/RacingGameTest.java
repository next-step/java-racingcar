package car.domain;

import car.domain.condition.RandomMovingStrategyImpl;
import car.ui.GameResult;
import car.ui.Winner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RacingGameTest {

    RacingGame game;
    Cars cars;

    @BeforeEach
    void setUp() {
        List<Car> participants = new ArrayList<>();
        participants.add(new Car(new Name("씽씽이")));
        participants.add(new Car(new Name("쏘카")));
        participants.add(new Car(new Name("그린카")));
        cars = Cars.of(participants);
        game = new RacingGame(new RandomMovingStrategyImpl(), cars);
    }

    @Test
    void 자동차_경주_게임을_시작한다() {
        // given
        int moveCount = 5;

        GameResult<List<Winner>> result = game.play(moveCount);
    }
}
