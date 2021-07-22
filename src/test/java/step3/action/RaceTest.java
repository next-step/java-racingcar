package step3.action;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {


    static Race race;

    @BeforeAll
    static void makeRace(){
        race = Race.of(2,10);
    }

    @DisplayName("객체생성 테스트")
    @Test
    void create(){
        race = Race.of(5,10);

        assertThat(race.getCarsSize()).isEqualTo(5);
        assertThat(race.getRaceTimes()).isEqualTo(10);
    }

    @DisplayName("레이싱 시작")
    @Test
    void raceTest(){
        race.doRace();
        List<Integer> expectList = Arrays.asList(new Integer[]{1,1});
        assertThat(race.getPositions()).isNotEqualTo(expectList);

    }
}