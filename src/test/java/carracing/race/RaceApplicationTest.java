package carracing.race;

import carracing.race.ui.InputView;
import carracing.race.ui.ResultView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;


public class RaceApplicationTest {
    private static final Logger log = Logger.getLogger("RaceApplicationTest");

    private RaceApplication raceApplication;

    @BeforeEach
    public void beforeEach() {
        raceApplication = new RaceApplication(new InputView(System.in,System.out),new ResultView(System.out));
    }

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
        log.info("테스트를 작성할 수 없는 애매함");
        fail();
    }

    @DisplayName("몇대의 자동차로 이동할수 있는지 지정할 수 있다")
    @Test
    public void countOfMovingCar() {
        //given
        //when
        //then
        log.info("테스트를 작성할 수 없는 애매함");
        fail();
    }

    @DisplayName("몇번을 이동할것인지 입력할 수 있다")
    @Test
    public void movingIteration() {
        //given
        //when
        //then
        log.info("테스트를 작성할 수 없는 애매함");
        fail();
    }

    @DisplayName("0에서 9사이에서 random값을 구한다")
    @RepeatedTest(20)
    @Test
    public void getRandomFrom0To9() {
        //given
        //when
        int random = raceApplication.getRandom();
        //then
        assertThat(random).isBetween(0, 9);
    }

    @DisplayName("3 초과(=4이상) 일 경우 전진한다")
    @Test
    public void forwardOver4() {
        //given
        //when
        //then
        log.info("테스트를 작성할 수 없는 애매함");
        fail();
    }

    @DisplayName("4 미만(=3이하) 일 경우 정지한다")
    @Test
    public void stopUnder4() {
        //given
        //when
        //then
        log.info("테스트를 작성할 수 없는 애매함");
        fail();
    }
}