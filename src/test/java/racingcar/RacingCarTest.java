package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.view.InputView.isPositiveNum;


import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Race;

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

    @DisplayName("시도횟수가 숫자가 아니거나 0이하일 수 없다.")
    @Test
    public void 숫자_0이하_입력() {
        assertThat(isPositiveNum(-1)).isFalse();
    }

    @Test
    public void 차이름_분리_확인() {
        assertThat(race.getCarList().get(0).getCarName()).isEqualTo("pobi");
        assertThat(race.getCarList().get(1).getCarName()).isEqualTo("crong");
    }

    @DisplayName("최대 이동 거리를 구할 수 있다.")
    @Test
    public void 차_최대_이동거리() {
        List<Car> carList = race.getCarList();
        for (int i = 0; i < 5; i++) {
            carList.get(0).goCar(5);
        }
        carList.get(1).goCar(5);
        race.setMaxDistance();
        assertThat(race.getMaxDistance()).isEqualTo(5);
    }

    @DisplayName("우승자를 구할 수 있다.")
    @Test
    public void 우승자1명() {
        List<Car> carList = race.getCarList();
        for (int i = 0; i < 5; i++) {
            carList.get(0).goCar(5);
        }
        carList.get(1).goCar(5);
        race.setMaxDistance();
        assertThat(race.getWinnerCarNames().get(0)).isEqualTo("pobi");
    }

    @DisplayName("우승자를 구할 수 있다.")
    @Test
    public void 우승자_여러명() {
        List<Car> carList = race.getCarList();
        for (int i = 0; i < 5; i++) {
            carList.get(0).goCar(5);
            carList.get(1).goCar(5);
        }

        race.setMaxDistance();
        assertThat(race.getWinnerCarNames().get(0)).isEqualTo("pobi");
        assertThat(race.getWinnerCarNames().get(1)).isEqualTo("crong");
    }
}