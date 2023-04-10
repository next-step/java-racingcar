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
import static org.junit.jupiter.api.Assertions.fail;


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

    @DisplayName("0에서 9사이에서 random값을 구한다")
    @RepeatedTest(100)
    public void getRandomFrom0To9() {
        //given
        //when
        //int random = raceApplication.randomScore();
        //then
        //assertThat(random).isBetween(0, 9);
        fail();
    }
}