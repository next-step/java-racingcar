package carracing.service;

import carracing.domain.Round;
import carracing.domain.Score;
import carracing.repository.RoundRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RacingServiceTest {
    private static final Logger log = Logger.getLogger("AutomobileFederationTest");
    private static final Map<Round, List<Score>> inputRoundToScoreListMap = Map.of(
        new Round(5), Arrays.asList(new Score(1), new Score(4), new Score(5)),
        new Round(1), Arrays.asList(new Score(7), new Score(3), new Score(9)),
        new Round(2), Arrays.asList(new Score(5), new Score(2), new Score(1)),
        new Round(3), Arrays.asList(new Score(9), new Score(4), new Score(5)),
        new Round(4), Arrays.asList(new Score(8), new Score(8), new Score(8))
    );

    private RacingService racingService;


    @BeforeEach
    public void beforeEach() {
        racingService = new RacingService(new RoundRepository());
    }

    @DisplayName("입력 결기경과의 수 대로 ")
    @Test
    public void run() {
        //given
        //federation.


        //when
        //then
        log.warning("테스트코드가 요구사항에 의존적이지 않고 구현에 의존적이다. 이렇게 되면 구현이 변경될때 테스트코드도 변경될 여지가 있다");
    }


    @DisplayName("입력한 경기수 (Round) 에 따라 해당 경기수만큼 잘 치뤄진건지 검증한다")
    @Test
    public void movingIteration() {
        //given
        int roundIterations = 22;

        //when
        Map<Round, List<Score>> roundListMap = racingService.racingStart(11, roundIterations);

        //then
        assertAll(
            () -> assertThat(roundListMap.keySet()).as("Round 숫자를 검증").hasSize(roundIterations),
            () -> assertThat(roundListMap.values()).as("List<Score> 를 검증").hasSize(roundIterations)
        );
    }


    @DisplayName("경기횟수 & 참가차량수 주어지면 그에 맞는 경기결과를 리턴한다")
    @Test
    public void participatesAndIterations() {
        //given
        int participates = 9;
        int iterations = 4;

        //when
        log.info("자동차 경주의 정보 > 참가자수=[{}명], 자동차 경주의 Round 횟수=[{}판]");
        Map<Round, List<Score>> raceResults = racingService.racingStart(participates, iterations);

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
        Map<Round, List<Score>> roundListMap = racingService.racingStart(participate, iterations);

        //then
        assertAll(
            () -> assertThat(roundListMap.keySet()).as("몇번 이동하는지 검증").hasSize(iterations),
            () -> assertThat(roundListMap.get(new Round(1))).as("몇대가 움직이는지 검증").hasSize(participate)
        );
    }



}