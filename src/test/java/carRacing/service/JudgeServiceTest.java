package carRacing.service;

import carRacing.dto.UserInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JudgeServiceTest {

    private JudgeService judgeService;

    @BeforeEach
    void setUp(){
        this.judgeService = new JudgeService();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1:2:false",
            "3:2:false",
            "0:3:false",
            "3:0:true"}, delimiter = ':')
    @DisplayName("게임 오버 상황을 판단할 수 있다")
    public void isGameOverDeterminingGameOver(int numberOfCars, int numberOfRace, boolean expected){
        UserInput userInput = new UserInput(numberOfCars, numberOfRace);
        assertEquals(judgeService.isGameOver(userInput), expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1:2:1",
            "3:3:2",
            "0:5:4"}, delimiter = ':')
    @DisplayName("남은 자동차 경주 횟수를 1씩 줄일 수 있다")
    public void checkRemainingRaceDeductsRace(int numberOfCars, int numberOfRace, int remainingRace){
        UserInput userInput = new UserInput(numberOfCars, numberOfRace);
        UserInput updatedUserInput = judgeService.checkRemainingRace(userInput);
        assertEquals(updatedUserInput.getNumberOfRace(), remainingRace);
    }

}