package racingcar;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingCarTest {
    private Race race;

    @BeforeEach
    void setRace() {
        race = new Race(new String[]{"pobi", "crong"}, 5);
    }

    @Test
    public void 자동차_생성() {
        assertThat(race.getCarList()).hasSize(2);
    }

    @Test
    public void 시도횟수_입력() {
        assertThat(race.getTryCount()).isEqualTo(5);
    }

    @Test
    public void 차이름_분리_확인(){
        assertThat(race.getCarList().get(0).getCarName()).isEqualTo("pobi");
        assertThat(race.getCarList().get(1).getCarName()).isEqualTo("crong");
    }
}