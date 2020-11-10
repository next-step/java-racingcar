package racingcar.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

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
    void clearTest(){
        racingResult.addMovingHistoryByTry(testMap);
        racingResult.setWinners(testList);

        racingResult.clear();
        assertThat(racingResult.getMovingHistoryByTry().size()).isEqualTo(0);
        assertThat(racingResult.getWinners().size()).isEqualTo(0);
    }

    @Test
    void getMovingHistoryByTryTest(){
        assertThat(racingResult.getMovingHistoryByTry()).isInstanceOf(List.class);
    }

    @Test
    void getWinnersTest(){
        assertThat(racingResult.getWinners()).isInstanceOf(List.class);
    }

    @Test
    void addMovingHistoryByTryTest(){
        racingResult.clear();
        int before = racingResult.getMovingHistoryByTry().size();
        racingResult.addMovingHistoryByTry(testMap);
        int after = racingResult.getMovingHistoryByTry().size();

        assertThat(before + 1).isEqualTo(after);

    }

    @Test
    void setWinnersTest(){
        racingResult.clear();
        racingResult.setWinners(testList);

        assertThat(racingResult.getWinners()).isEqualTo(testList);
    }
}
