package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingGame;
import racingcar.model.RacingCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private static RacingGame rgc;

    @DisplayName("getCars() 의 유효성 검증")
    @Test
    void setCarsNameTest() {

        rgc = new RacingGame("pobi,woni,jun", 5);

        ArrayList<RacingCar> cars = rgc.getCars();

        assertThat(cars.get(0).getName()).isEqualTo("pobi");
        assertThat(cars.get(1).getName()).isEqualTo("woni");
        assertThat(cars.get(2).getName()).isEqualTo("jun");
    }

    @DisplayName("승리자 선정 로직 검증")
    @Test
    void findTwoWinnerTest() {

        rgc = new RacingGame("pobi,woni,jun", 5);

        rgc.getCars().get(0).setStatus(5);
        rgc.getCars().get(1).setStatus(2);
        rgc.getCars().get(2).setStatus(5);
        List<String> answer = new ArrayList<>(Arrays.asList("pobi","jun"));
        rgc.findWinnerWithMaxStatus(5);
        assertThat(rgc.getWinners()).isEqualTo(answer);

    }


}
