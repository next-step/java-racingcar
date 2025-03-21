import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameServiceTest {
    @Test
    void 우승자_반환() {
        Car finn = new Car("finn" ,2);
        Car foo = new Car("foo", 1);
        Car var = new Car("var", 2);
        GameService gameService = new GameService(List.of(finn,foo,var));

        List<Car> winners = gameService.getWinners();
        assertThat(winners).containsExactlyInAnyOrder(finn, var);
    }
}
