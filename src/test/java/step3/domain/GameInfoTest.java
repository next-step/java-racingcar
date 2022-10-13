package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.util.Separation;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameInfoTest {

    private Separation separation = new Separation();
    private List<String> names = new ArrayList<>();

    int count = 5;

    @BeforeEach
    void beforeEach() {
        names = separation.nameSeparation("pobi,crong,honux");
    }

    @Test
    @DisplayName("게임정보 세팅 테스트")
    void createGameInfoTest() {
        GameInfo gameInfo = new GameInfo(new Cars(names), count);
        assertThat(gameInfo.getCount()).isEqualTo(count);
    }
}