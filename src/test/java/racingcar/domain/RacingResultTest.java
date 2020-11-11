package racingcar.domain;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RacingResultTest {
    private RacingResult racingResult;
    private Map<String, Integer> testMap;
    private List<String> testList;

    @BeforeAll
    void setUp(){
        racingResult = new RacingResult();
        testMap = new LinkedHashMap<>();
        testList = new ArrayList<>();
    }

    @Test
    @DisplayName("getMovingHistoryByTry() 테스")
    void getMovingHistoryByTryTest(){
        assertThat(racingResult.getMovingHistoryByTry()).isInstanceOf(List.class);
    }

    @Test
    @DisplayName("getWinners() 테스트")
    void getWinnersTest(){
        assertThat(racingResult.getWinners()).isInstanceOf(List.class);
    }

    @Test
    @DisplayName("addMovingHistoryByTry() 테스트")
    void addMovingHistoryByTryTest(){
        int before = racingResult.getMovingHistoryByTry().size();
        racingResult.addMovingHistoryByTry(testMap);
        int after = racingResult.getMovingHistoryByTry().size();

        assertThat(before + 1).isEqualTo(after);
    }

    @Test
    @DisplayName("setWinners() 테스트")
    void setWinnersTest(){
        racingResult.setWinners(testList);

        assertThat(racingResult.getWinners()).isEqualTo(testList);
    }
}
