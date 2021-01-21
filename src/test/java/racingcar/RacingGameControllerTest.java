package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class RacingGameControllerTest {
    private static RacingGameController rgc;
    private static InputStream in;

    @BeforeAll
    static void initAll() {
        rgc = new RacingGameController();
    }

    @Test
    void setCarsNameTest() {
        rgc.setCarsName("pobi,woni,jun");

        ArrayList<RacingCar> cars = rgc.getCars();

        Assertions.assertThat(cars.get(0).getName()).isEqualTo("pobi");
        Assertions.assertThat(cars.get(1).getName()).isEqualTo("woni");
        Assertions.assertThat(cars.get(2).getName()).isEqualTo("jun");
    }

    @Test
    void findTwoWinnerTest() {

        rgc.setCarsName("pobi,woni,jun");

        rgc.getCars().get(0).setStatus(5);
        rgc.getCars().get(1).setStatus(2);
        rgc.getCars().get(2).setStatus(5);
        List<String> answer = new ArrayList<>();
        answer.add("pobi");
        answer.add("jun");
        rgc.findWinner();
        Assertions.assertThat(rgc.getWinners()).isEqualTo(answer);

    }
}
