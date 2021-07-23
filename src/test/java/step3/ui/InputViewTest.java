package step3.ui;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private final PrintStream standOut = System.out;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standOut);
    }

    @Test
    @DisplayName("게임에 참여할 자동차 대수를 묻는 UI 텍스트 검증하기")
    void askHowManyCars() {
        InputView.askHowManyCars();

        assertThat(outputStream.toString().trim()).isEqualTo("자동차 대수는 몇 대 인가요?");
    }

    @Test
    @DisplayName("게임의 시도회수를 묻는 UI 텍스트 검증하기")
    void askHowManyTryCounts() {
        InputView.askHowManyTryCounts();

        assertThat(outputStream.toString().trim()).isEqualTo("시도할 회수는 몇 회 인가요?");
    }


}