package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {
    @Test
    @DisplayName("경주를 생성하면 입력받은 대수만큼의 차가 초기 위치에 생성된다")
    public void race_Initial() {
        Race race = new Race(3, 2);
        assertThat(race.toCarDtoList().get(0).getPosition()).isZero();
        assertThat(race.toCarDtoList().get(1).getPosition()).isZero();
        assertThat(race.toCarDtoList().get(2).getPosition()).isZero();
    }

    @Test
    @DisplayName("경주를 1회 진행하면 조건에 따라 차들이 이동한다")
    public void race_OneTry() {
        Race race = new Race(3, 2);
        race.continueRace(List.of(3, 4, 5));
        assertThat(race.toCarDtoList().get(0).getPosition()).isZero();
        assertThat(race.toCarDtoList().get(1).getPosition()).isOne();
        assertThat(race.toCarDtoList().get(2).getPosition()).isOne();
    }

    @Test
    @DisplayName("현재까지 시도 회수가 입력받은 총 시도 회수보다 작으면 경주를 마치지 않는다.")
    public void race_NotFinished() {
        Race race = new Race(3, 2);
        race.continueRace(List.of(3, 4, 5));
        assertThat(race.isNotFinished()).isTrue();
    }

    @Test
    @DisplayName("현재까지 시도 회수가 입력받은 총 시도 회수와 같으면 경주를 마친다.")
    public void race_Finished() {
        Race race = new Race(3, 2);
        race.continueRace(List.of(3, 4, 5));
        race.continueRace(List.of(3, 4, 5));
        assertThat(race.isNotFinished()).isFalse();
    }
}
