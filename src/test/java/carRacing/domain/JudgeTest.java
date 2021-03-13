package carRacing.domain;

import carRacing.dto.UserInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JudgeTest {

    private Judge judge;

    @BeforeEach
    void setUp() {
        this.judge = new Judge();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1:2:false",
            "3:2:false",
            "0:3:false",
            "3:0:true"}, delimiter = ':')
    @DisplayName("게임 오버 상황을 판단할 수 있다")
    void isGameOverDeterminingGameOver(int numberOfCars, int numberOfRace, boolean expected) {
        UserInput userInput = new UserInput(numberOfCars, numberOfRace);
        assertEquals(judge.isGameOver(userInput), expected);
    }

    @Test
    @DisplayName("심판의 시간 카운트를 1씩 증가시킬 수 있다")
    void recordTimeIncreasesTimeCount() {
        for (int count = 1; count <= 100; count++) {
            judge.recordTime();
            assertEquals(judge.getCount(), count);
        }
    }

}
