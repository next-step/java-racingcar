package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RacingCarGame;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest {

    @Test
    @DisplayName("입력한 자동차 이름에 맞춰 경주에 참여하는 차 리스트 생성")
    public void createCarTest() {
        List<String> carNameList = Arrays.asList("yuno", "bingb");
        RacingCarGame racingCarGame = new RacingCarGame(carNameList, 0);
        List<Car> carList = racingCarGame.getCarList();

        assertThat(carList).hasSize(2);
    }

    @Test
    @DisplayName("경주 시도할 횟수 라운드 진행후 게임 끝나는지 확인")
    void isEndTest() {
        List<String> carNameList = Arrays.asList("yuno", "bingb");
        RacingCarGame racingCarGame = new RacingCarGame(carNameList, 3);

        racingCarGame.playOneRound();
        assertThat(racingCarGame.isEnd()).isFalse();
        racingCarGame.playOneRound();
        assertThat(racingCarGame.isEnd()).isFalse();
        racingCarGame.playOneRound();
        assertThat(racingCarGame.isEnd()).isTrue();
    }
}
