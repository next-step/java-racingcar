package step3.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.car.Names;

import static org.assertj.core.api.Assertions.assertThat;

class GameDirectorTest {

    private static final String NAME = "길동";
    private static final String DELIMITER = ",";
    private static final int END_ROUND = 0;

    @DisplayName("n개의 이름이 주어졌을 때 게임을 n번 진행하는지 테스트")
    @Test
    void playGameTest() {
        //given
        int carCount = 5;
        int roundSize = 10;
        String stringNames = createStringNames(carCount);

        Names names = Names.from(stringNames);
        Round round = new Round(roundSize);
        GameDirector gameDirector = new GameDirector(names, round);

        //when
        gameDirector.playGame();

        //then
        assertThat(round).isEqualTo(new Round(END_ROUND));
    }

    private String createStringNames(int carCount) {
        StringBuilder stringNames = new StringBuilder().append(NAME);
        for (int i = 1; i < carCount; i++) {
            stringNames.append(DELIMITER)
                    .append(NAME);
        }
        return stringNames.toString();
    }

}
