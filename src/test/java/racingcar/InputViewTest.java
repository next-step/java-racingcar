package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void 시스템_아웃_세팅() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

//    @Test
//    void 레이스_회수_입력() {
//        assertThat().isEqualTo(2);
//    }
//
//    @Test
//    void 레이스_회수_입력_질문() {
//        assertThat(outputStream.toString()).contains("시도할 회수는 몇 회 인가요?");
//    }
//
//    @Test
//    void 자동차_대수_입력() {
//        assertThat(InputView.askCarCount("3")).isEqualTo(3);
//    }
//
//    @Test
//    void 자동차_대수_입력_질문() {
//        InputView.askCarCount("3");
//        assertThat(outputStream.toString()).contains("자동차 대수는 몇 대 인가요?");
//    }

}
