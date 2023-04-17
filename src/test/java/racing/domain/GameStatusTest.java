package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.FixedRandomForwardStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class GameStatusTest {

    @Test
    @DisplayName("게임 상태 결과 확인")
    void create() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("pobi", new FixedRandomForwardStrategy(5)));
        carList.add(new Car("crong", new FixedRandomForwardStrategy(5)));
        carList.add(new Car("honux", new FixedRandomForwardStrategy(0)));
        carList.get(0).move();

        GameStatus gameStatus = new GameStatus(carList);
        Set<String> participants = gameStatus.getParticipants();
        for (String participant : participants) {
            if (participant.equals("pobi")) {
                assertThat(gameStatus.getPositionByName(participant)).isEqualTo(1);
            } else {
                assertThat(gameStatus.getPositionByName(participant)).isEqualTo(0);
            }
        }
    }
}