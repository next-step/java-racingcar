package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    RacingDTO racingDTO;
    // @Test 메소드 실행되기전 수행
    @BeforeEach
    void setUp(){
        racingDTO = new RacingDTO(3,5);
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
        Car testCar = new Car();
        racingGame.instructMove(testCar);

        assertThat(testCar.recordList.size()).isEqualTo(racingDTO.getAttempts());
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

        int counts = racingDTO.getCounts();
        int attempts = racingDTO.getAttempts();

        ResultView resultView = new ResultView(counts, attempts);
        resultView.showResult(racingGame.getCars());
    }


}
