package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import racingcar.common.utils.TextManipulator;
import racingcar.model.movestrategy.FixedMoveStrategy;
import racingcar.model.movestrategy.RandomMoveStrategy;

@TestMethodOrder(OrderAnnotation.class)
class RacingCarGameTest {

        @Test
        void 입력한_자동차_이름_갯수만큼_해당_이름을_가진_자동차_생성() {
                String carNamesInOneText = "aaaaa, bbbbb, ccccc, ddddd, eeeee";
                int round = 5;
                String[] carNames = TextManipulator.splitTextByComma(carNamesInOneText);
                RacingCarGame game = new RacingCarGame(round, new RandomMoveStrategy(), carNames);
                assertThat(game.cars().values()).hasSize(carNames.length);
        }

        @Test
        void 자동차_경주_1라운드_정상_실행() {
                String carNamesInOneText = "aaaaa, bbbbb, ccccc, ddddd, eeeee";
                int round = 5;
                String[] carNames = TextManipulator.splitTextByComma(carNamesInOneText);
                RacingCarGame game = new RacingCarGame(round, new FixedMoveStrategy(7), carNames);
                game.moveOneRound();
                assertThat(
                    game.cars().values().stream().allMatch(value -> value.currentPosition().getValue() == 2)).isTrue();
        }
}
