package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class GameTest {


    @DisplayName("Game 생성 시에 RuleDto에 count나 time 은 null이면 안된다.")
    @Test
    void ofTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Game.of(Rule.from(null, 10), () -> true);
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            Game.of(Rule.from(10, null), () -> true);
        });
    }

    @DisplayName("매번 움직이는 정상 케이스 동작 테스트")
    @Test
    void moveAlwaysTest() {
        Integer count = 3;
        Integer time = 3;
        Game game = Game.of(Rule.from(count, time), () -> true);

        game.start();

        Position one = Position.create(1);
        Position two = Position.create(2);
        Position three = Position.create(3);
        List<Position> oneStep = Arrays.asList(one, one, one);
        List<Position> twoStep = Arrays.asList(two, two, two);
        List<Position> threeStep = Arrays.asList(three, three, three);

        GameHistory gameHistory = game.getGameHistory();
        assertThat(gameHistory.getHistory(0)).isEqualTo(oneStep);
        assertThat(gameHistory.getHistory(1)).isEqualTo(twoStep);
        assertThat(gameHistory.getHistory(2)).isEqualTo(threeStep);


    }


}