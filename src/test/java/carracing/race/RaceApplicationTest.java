package carracing.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


class RaceApplicationTest {

    private RaceApplication raceApplication;

    @DisplayName("경기횟수, 참가차량수가 주어지면 경기결과를 리턴한다")
    @Test
    public void run() {
        //given
        int parti = 0;
        int iter = 0;

        //when
        Map<Integer, List<Integer>> raceResults = raceApplication.racingStart(parti, iter);

        //then
        assertThat(raceResults.keySet()).hasSize(parti); // 경기 참가자수 검증
        assertThat(raceResults.values()).hasSize(parti);
        //횟수검증
        raceResults.values().stream().forEach(s -> {
            assertThat(s).hasSize(iter);
        });
    }

    @DisplayName("n대의 자동차는 전진 또는 멈출 수 있다")
    @Test
    public void carCanMoveOrStop() {
        //given
        //when
        //then
    }

    @DisplayName("몇대의 자동차로 이동할수 있는지 지정할 수 있다")
    @Test
    public void countOfMovingCar() {
        //given
        //when
        //then
    }

    @DisplayName("몇번을 이동할것인지 입력할 수 있다")
    @Test
    public void movingIteration() {
        //given
        //when
        //then
    }

    @DisplayName("0에서 9사이에서 random값을 구한다")
    @Test
    public void getRandomFrom0To9() {
        //given
        //when
        //then
    }

    @DisplayName("3 초과(=4이상) 일 경우 전진한다")
    @Test
    public void forwardOver4() {
        //given
        //when
        //then
    }

    @DisplayName("4 미만(=3이하) 일 경우 정지한다")
    @Test
    public void stopUnder4() {
        //given
        //when
        //then
    }
}