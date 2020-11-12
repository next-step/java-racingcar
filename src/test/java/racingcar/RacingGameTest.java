package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    RacingDTO racingDTO;
    // @Test 메소드 실행되기전 수행
    @BeforeEach
    void setUp(){
        String inputName = "pobi,crong,honux";
        racingDTO = new RacingDTO(inputName,5);
    }

    @Test
    @DisplayName("생성된 자동차 객체수 확인 테스트")
    public void numberOfCarTest(){
        RacingGame racingGame = new RacingGame(racingDTO);
        assertThat(racingGame.getCars()).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차 경기 진행 지시 테스트")
    public void instructionTest(){
        RacingGame racingGame = new RacingGame(racingDTO);
        Car testCar = new Car("pobi");
        racingGame.instructMove(testCar);

        assertThat(testCar.getRecordList().size()).isEqualTo(racingDTO.getAttempts());
    }

    @Test
    @DisplayName("경기 테스트")
    public void racingTest(){
        RacingGame racingGame = new RacingGame(racingDTO);
        racingGame.start();
    }

    @Test
    @DisplayName("경기 진행 및 결과 출력 테스트")
    public void resultTest(){
        RacingGame racingGame = new RacingGame(racingDTO);
        racingGame.start();
        List<String> winners = racingGame.end();

        int counts = racingDTO.getNames().length;
        int attempts = racingDTO.getAttempts();

        ResultView resultView = new ResultView(counts, attempts);
        resultView.showResult(racingGame.getCars());
        resultView.announceWinner(winners);
    }


}