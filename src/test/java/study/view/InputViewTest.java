package study.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.domain.GameInfo;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    @Test
    @DisplayName("입력을 통하여, 차의 개수와 게임 횟수가 제대로 출력되는지에 대한 테스트 ")
    void prepareGame() {
        // given
        String nameListInput = "최태훈,조아영,김정환";
        int inputNumberOfGame = 3;
        String userInput = String.format("%s%s%d",
                nameListInput, System.lineSeparator(), inputNumberOfGame);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(byteArrayInputStream);

        GameInfo gameInfo = InputView.prepareGame();

        assertThat(gameInfo.getNameList().size()).isEqualTo(3);

        assertThat(gameInfo.getNameList()).contains("최태훈", "조아영", "김정환");

        assertThat(gameInfo.getNumberOfGame()).isEqualTo(inputNumberOfGame);
    }
}