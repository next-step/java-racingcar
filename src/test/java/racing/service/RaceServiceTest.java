package racing.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.RaceHistory;

import static org.assertj.core.api.Assertions.assertThat;


class RaceServiceTest
{

    private final static String CAR_NAMES_STRING_TO_TEST = "test1,test2,test3";

    private static RaceService raceService;
    @BeforeEach
    void setUp()
    {
        raceService = RaceService.getInstance();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    @DisplayName("턴별 레이스 history가 자동차댓수 크기와 같은지 확인한다.")
    void carRacingGameTest2(int testTurn) {
        String[] carNames = CAR_NAMES_STRING_TO_TEST.split(",");
        RaceHistory raceHistory = raceService.gameStart(carNames, testTurn);

        assertThat(raceHistory.getHistoryByTurn(testTurn)).hasSize(carNames.length);
    }
}