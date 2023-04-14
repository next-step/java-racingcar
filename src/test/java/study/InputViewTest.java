package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @Test
    @DisplayName("입력을 통하여, 차의 개수와 게임 횟수가 제대로 출력되는지에 대한 테스트 ")
    void prepareGame() {
        // given
        int inputNumberOfCar = 13;
        int inputNumberOfGame = 3;
        String userInput = String.format("%d%s%d",
                inputNumberOfCar, System.lineSeparator(), inputNumberOfGame);

        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        GameInfo gameInfo = InputView.prepareGame();


        assertThat(gameInfo.getNumberOfCar()).isEqualTo(inputNumberOfCar);
        assertThat(gameInfo.getNumberOfGame()).isEqualTo(inputNumberOfGame);
    }
}