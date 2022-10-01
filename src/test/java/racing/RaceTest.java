package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class RaceTest {

    @Test
    void 자동차_경주_결과_경기_횟수_확인(){
        Race race = new Race(3, 5);
        race.play();

        ArrayList<ArrayList<Integer>> result = race.result();

        Assertions.assertThat(result).hasSize(5);
    }

    @Test
    void 자동차_경주_결과_자동차_댓수_확인(){
        Race race = new Race(3, 5);
        race.play();
        ArrayList<ArrayList<Integer>> result = race.result();

        Assertions.assertThat(result.get(0)).hasSize(3);
    }

}