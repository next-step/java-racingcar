package step5;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    void 레이싱게임_테스트() {
        String[] carNames = new String[]{"car1", "car2", "car3"};
        RacingGameInputData inputData = new RacingGameInputData(3, carNames);
        RacingGame racingGame = new RacingGame(inputData);
        ResultDto resultDto = racingGame.race(() -> true);//무조건 전진
        List<Cars> resultLogs = resultDto.getRacingLog();

        //logs 검증
        int i = 0;
        for (Cars cars : resultLogs) {
            i++;
            final int j = i;
            cars.getCars().forEach(o -> assertThat(o.isEqualsProgress(j)).isTrue());
        }
        //winners 검증
        assertThat(resultDto.getWinners()).containsExactly("car1", "car2", "car3");


    }

}
