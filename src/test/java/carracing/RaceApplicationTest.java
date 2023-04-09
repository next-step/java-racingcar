package carracing;

import carracing.logic.type.Round;
import carracing.logic.type.Score;
import carracing.ui.InputView;
import carracing.ui.ResultView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;


public class RaceApplicationTest {
    private static final Logger log = Logger.getLogger("RaceApplicationTest");

    private RaceApplication raceApplication;
    private OutputStream resultViewOutputStream;
    private PrintStream resultViewPrintStream;
    private ResultView resultView;
    private InputView inputView;
    private InputStream inputViewInputStream;

    @BeforeEach
    public void beforeEach() {
        this.resultViewOutputStream = new ByteArrayOutputStream();
        this.resultViewPrintStream = new PrintStream(new PrintStream(this.resultViewOutputStream));
        this.resultView = new ResultView(this.resultViewPrintStream);
        this.inputViewInputStream = new ByteArrayInputStream("SampleInput".getBytes());
        this.inputView = new InputView(inputViewInputStream, resultViewPrintStream);
        this.raceApplication = new RaceApplication(this.inputView, this.resultView);
    }

    @DisplayName("경기횟수, 참가차량수가 주어지면 경기결과를 리턴한다")
    @Test
    public void participatesAndIterations() {
        //given
        int participates = 9;
        int iterations = 4;

        //when
        log.info("자동차 경주의 정보 > 참가자수=[{}명], 자동차 경주의 Round 횟수=[{}판]");
        Map<Round, List<Score>> raceResults = raceApplication.racingStart(participates, iterations);

        //then
        assertAll(
                () -> assertThat(raceResults.keySet()).as("경기 반복횟수 검증").hasSize(iterations),
                () -> assertThat(raceResults.get(new Round(1))).as("경기 참가자수 검증 - 1번경가").hasSize(participates),
                () -> raceResults.values().forEach(s -> assertThat(s).as("경기 참가자수 검증 - 모든경가").hasSize(participates))
        );
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
        int participate = 11;
        int iterations = 22;

        //when
        Map<Round, List<Score>> roundListMap = raceApplication.racingStart(participate, iterations);

        //then
        assertAll(
                () -> assertThat(roundListMap.keySet()).as("몇번 이동하는지 검증").hasSize(iterations),
                () -> assertThat(roundListMap.get(new Round(1))).as("몇대가 움직이는지 검증").hasSize(participate)
        );
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