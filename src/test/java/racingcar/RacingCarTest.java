package racingcar;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

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
    public void 차이름_분리_확인() {
        assertThat(race.getCarList().get(0).getCarName()).isEqualTo("pobi");
        assertThat(race.getCarList().get(1).getCarName()).isEqualTo("crong");
    }

    @Test
    public void 차_최대_이동거리() {
        List<Car> carList = race.getCarList();
        for (int i = 0; i < 5; i++) {
            carList.get(0).setGoCar(5);
        }
        carList.get(1).setGoCar(5);
        race.setMaxDistance();
        assertThat(race.getMaxDistance()).isEqualTo(5);
    }

    @Test
    public void 우승자1명() {
        List<Car> carList = race.getCarList();
        for (int i = 0; i < 5; i++) {
            carList.get(0).setGoCar(5);
        }
        carList.get(1).setGoCar(5);
        race.setMaxDistance();
        assertThat(race.getWinnerCarList().get(0)).isEqualTo("pobi");
    }

    @Test
    public void 우승자_여러명() {
        List<Car> carList = race.getCarList();
        for (int i = 0; i < 5; i++) {
            carList.get(0).setGoCar(5);
            carList.get(1).setGoCar(5);
        }

        race.setMaxDistance();
        assertThat(race.getWinnerCarList().get(0)).isEqualTo("pobi");
        assertThat(race.getWinnerCarList().get(1)).isEqualTo("crong");
    }
}