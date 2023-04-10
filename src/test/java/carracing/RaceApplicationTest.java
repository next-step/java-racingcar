package carracing;

import carracing.domain.Round;
import carracing.domain.Score;
import carracing.presentation.InputPresentation;
import carracing.presentation.ResultPresentation;
import carracing.presentation.impl.ResultPresentationV1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


public class RaceApplicationTest {
    private static final Logger log = Logger.getLogger("RaceApplicationTest");

    private RaceApplication raceApplication;
    private OutputStream resultViewOutputStream;
    private PrintStream resultViewPrintStream;
    private ResultPresentation resultPresentation;
    private InputPresentation inputPresentation;
    private InputStream inputViewInputStream;

    @BeforeEach
    public void beforeEach() {
        this.resultViewOutputStream = new ByteArrayOutputStream();
        this.resultViewPrintStream = new PrintStream(new PrintStream(this.resultViewOutputStream));
        this.resultPresentation = new ResultPresentationV1(this.resultViewPrintStream);
        this.inputViewInputStream = new ByteArrayInputStream("SampleInput".getBytes());
        this.inputPresentation = new InputPresentation(inputViewInputStream, resultViewPrintStream);
        this.raceApplication = new RaceApplication(this.inputPresentation, this.resultPresentation);
    }

    private void inAndOutTestHelper(String inputString) {
        this.inputViewInputStream = new ByteArrayInputStream(inputString.getBytes());
        this.inputPresentation = new InputPresentation(inputViewInputStream, resultViewPrintStream);
        this.raceApplication = new RaceApplication(this.inputPresentation, this.resultPresentation);
    }

    @DisplayName("경기횟수 & 참가차량수 주어지면 그에 맞는 경기결과를 리턴한다")
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

    @DisplayName("몇대의 자동차로 이동할수 있는지 지정할 수 있다")
    @Test
    public void countOfMovingCar() {
        //given
        int participate = 55;
        int iterations = 33;

        //when
        Map<Round, List<Score>> roundListMap = raceApplication.racingStart(participate, iterations);

        //then
        assertAll(
            () -> assertThat(roundListMap.keySet()).as("몇번 이동하는지 검증").hasSize(iterations),
            () -> assertThat(roundListMap.get(new Round(1))).as("몇대가 움직이는지 검증").hasSize(participate)
        );
    }

    @DisplayName("문구 출력 검증 : [자동차 대수는 몇 대 인가요?] 출력된다")
    @Test
    public void participates() {
        //given
        String answer = "자동차 대수는 몇 대 인가요?";
        inAndOutTestHelper("5\r\n5");

        //when
        raceApplication.run();

        //then
        assertThat(resultViewOutputStream.toString()).contains(answer);
    }

    @Disabled("피할수 없다")
    @DisplayName("문구 출력 검증 : [시도할 횟수는 몇 회 인가요?] 출력된다")
    @Test
    public void iterations() {
        //todo >> 두번째 입력값인 시도할 횟수 << 문구가 잘 출력되는지 검증할 방법이 없다...

        //given
        String answer = "시도할 횟수는 몇 회 인가요?";
        inAndOutTestHelper("4\r6\r8");

        //when
        raceApplication.run();

        //then
        assertThat(resultViewOutputStream.toString().trim()).contains(answer);
    }

    @DisplayName("입력한 경기수 (Round) 에 따라 해당 경기수만큼 잘 치뤄진건지 검증한다")
    @Test
    public void movingIteration() {
        //given
        int roundIterations = 22;

        //when
        Map<Round, List<Score>> roundListMap = raceApplication.racingStart(11, roundIterations);

        //then
        assertAll(
            () -> assertThat(roundListMap.keySet()).as("Round 숫자를 검증").hasSize(roundIterations),
            () -> assertThat(roundListMap.values()).as("List<Score> 를 검증").hasSize(roundIterations)
        );
    }

    @DisplayName("0에서 9사이에서 random값을 구한다")
    @RepeatedTest(100)
    public void getRandomFrom0To9() {
        //given
        //when
        int random = raceApplication.randomScore();
        //then
        assertThat(random).isBetween(0, 9);
    }
}