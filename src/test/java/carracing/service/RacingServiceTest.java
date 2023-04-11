package carracing.service;

import carracing.domain.Score;
import carracing.repository.RoundRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.fail;

public class RacingServiceTest {
    private static final Logger log = Logger.getLogger("AutomobileFederationTest");

    private RacingService racingService;
    private RoundRepository roundRepository;

    @BeforeEach
    public void beforeEach() {
        this.roundRepository = new RoundRepository();
        this.racingService = new RacingService(roundRepository);
    }


    @DisplayName("입력한 경기수 (Round) 에 따라 해당 경기수만큼 잘 치뤄진건지 검증한다")
    @Test
    public void movingIteration() {
        //given
        int roundIterations = 22;

        //when
        racingService.racingStart(11, roundIterations);

        //then
        assertThat(racingService.findAll()).as("Round 숫자를 검증").hasSize(roundIterations);
    }


    @DisplayName("경기횟수 & 참가차량수 주어지면 그에 맞는 경기결과를 리턴한다")
    @Test
    public void participatesAndIterations() {
        //given
        int participates = 9;
        int iterations = 4;

        //when
        log.info("자동차 경주의 정보 > 참가자수=[{}명], 자동차 경주의 Round 횟수=[{}판]");
        racingService.racingStart(participates, iterations);

        //then
        assertAll(
            () -> assertThat(racingService.racingResults()).as("경기 반복횟수 검증").hasSize(iterations),
            () -> assertThat(racingService.findAll()).as("경기 참가자수 검증 - 1번경가").hasSize(participates),
            () -> racingService.findAll().forEach(s -> assertThat(s.getRecords()).as("경기 참가자수 검증 - 모든경가").hasSize(participates))
        );
    }

    @DisplayName("참가차량수 주어지면 그에 맞는 경기결과를 리턴한다")
    @Test
    public void participatesAndIteratsions() {
        //given
        int participates = 9;

        //when
        log.info("자동차 경주의 정보 > 참가자수=[{}명], 자동차 경주의 Round 횟수=[{}판]");
        racingService.roundStart(participates);

        //then
        assertAll(
            () -> assertThat(racingService.racingResults().as("경기 참가자수 검증 - 1번경가").hasSize(participates),
            () -> racingService.findAll().forEach(s -> assertThat(s.getRecords()).as("경기 참가자수 검증 - 모든경가").hasSize(participates))
        );
    }

    @DisplayName("몇대의 자동차로 이동할수 있는지 지정할 수 있다")
    @Test
    public void countOfMovingCar() {
        //given
        int participate = 55;
        int iterations = 33;

        //when
//        Map<Round, List<Score>> roundListMap = racingService.racingStart(participate, iterations);
//
//        //then
//        assertAll(
//            () -> assertThat(roundListMap.keySet()).as("몇번 이동하는지 검증").hasSize(iterations),
//            () -> assertThat(roundListMap.get(new Round(1))).as("몇대가 움직이는지 검증").hasSize(participate)
//        );fail();
        fail();

    }


    @DisplayName("0에서 9사이에서 random값을 구한다")
    @Test
    public void getRandomFrom0To9() {
        //given
        racingService.racingStart(10, 10);

        //when
        List<List<Score>> allScores = roundRepository.findAll().stream().map(round -> round.getScores()).collect(Collectors.toList());

        //then
        allScores.stream()
            .flatMap(scores -> scores.stream())
            .forEach(score -> assertThat(score.getValue()).isBetween(0, 9));


    }

}