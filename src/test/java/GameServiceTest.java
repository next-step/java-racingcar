import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameServiceTest {
    @Test
    void 자동차_이름_컴마구분자_생성() {
        GameService gameService = new GameService("finn,foo,var");
        assertThat(gameService.carNumber()).isEqualTo(3);
    }
}
