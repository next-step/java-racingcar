package carRacing.service;

import carRacing.dto.UserInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RaceServiceTest {

    private RaceService raceService;

    @BeforeEach
    void setUp(){
        this.raceService = new RaceService();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1:2:1",
            "3:2:3"}, delimiter = ':')
    @DisplayName("스코어보드를 초기화할 수 있다")
    public void prepareScoreboardReturnsScoreboard(int numberOfCars, int numberOfRace, int expected){
        UserInput userInput = new UserInput(numberOfCars, numberOfRace);
        List<String> scoreboard = raceService.prepareScoreboard(userInput);
        assertEquals(scoreboard.size(), expected);
    }

    @Test
    @DisplayName("스코어보드를 업데이트할 수 있다")
    public void updateScoreboardReturnsUpdatedScoreboard(){
        for(int iter = 0;iter<100;iter++){
            List<String> scoreboard = new ArrayList<>();
            for(int carCount = 0;carCount<iter;carCount++){
                scoreboard.add("");
            }
            List<String> updateScoreboard = raceService.updateScoreboard(scoreboard);
            assertEquals(scoreboard.size(), updateScoreboard.size());
        }
    }

    @Test
    @DisplayName("확률에 기반하여 자동차가 움직이거나 움직이지 않는다")
    public void raceOrStayReturnsUpdatedScore(){
        for(int iter = 0;iter<100;iter++){
            String result = raceService.raceOrStay("");
            assertTrue((result.equals("")||result.equals("-")));
        }
    }

}