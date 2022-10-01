package racing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class RaceTest {


    @Test
    void 자동차_경주_결과_테스트() {
        Race race = new Race(3, 5, new NoRule());
        race.play();
        ArrayList<ArrayList<Integer>> result = race.result();
        assertThat(result).isEqualTo(
                List.of(
                        List.of(1, 1, 1),
                        List.of(2, 2, 2),
                        List.of(3, 3, 3),
                        List.of(4, 4, 4),
                        List.of(5, 5, 5)
                )
        );
    }

}