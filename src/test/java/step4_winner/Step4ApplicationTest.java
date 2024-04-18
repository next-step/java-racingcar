package step4_winner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.NoSuchElementException;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class Step4ApplicationTest {

    private final InputStream stdIn = System.in;
    private final PrintStream stdOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUpPrintStream() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreSystemIn() {
        System.setIn(stdIn);
        System.setOut(stdOut);
    }

    @Test
    @DisplayName("CarRacingWinner는 인스턴스화 할 수 없다")
    void NonInstanceCarRacingWinner() throws NoSuchMethodException {
        // GIVEN
        Constructor<Step4Application> constructor = Step4Application.class.getDeclaredConstructor();
        assertThat(constructor.canAccess(null)).isFalse();

        // WHEN
        constructor.setAccessible(true);
        Throwable throwable = catchThrowable(constructor::newInstance);

        // 리플렉션을 사용하여 생성자를 호출하면, 생성자 내부에서 발생하는 예외는 InvocationTargetException에 감싸져서 발생
        assertThat(throwable).isInstanceOf(InvocationTargetException.class);
        // 그 내부의 cause를 검사해서 실제 UnsupportedOperationException가 발생하는지 확인
        assertThat(throwable.getCause()).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("Input Test")
    void CarRacingWinnerInputTest() {
        // GIVEN 1번만 시도
        provideInput("a,b,c,d,e,f,g", "1");

        // WHEN
        Step4Application.main(new String[]{});

        // THEN
        String outputStreamCaptorString = outContent.toString();
        String raceResult = outputStreamCaptorString.split("\n실행 결과\n", 2)[1];

        long linesCount = raceResult.lines().count();
        assertThat(linesCount).isEqualTo(9L);

        long emptyLinesCount = raceResult.lines().filter(String::isEmpty).count();
        assertThat(emptyLinesCount).isEqualTo(1L);

    }

    @Test
    @DisplayName("입력된 값이 없으면 NoSuchElementException")
    void throwNoSuchElementExceptionIfNoInput() {
        // GIVEN
        provideInput("", "");

        // WHEN
        Throwable IllegalThrown = catchThrowable(() -> Step4Application.main(new String[]{}));

        // THEN
        assertThat(IllegalThrown)
                .isInstanceOf(NoSuchElementException.class);
    }

    private void provideInput(String... strings) {
        String inputStr = String.join("\n", strings);
        System.setIn(new ByteArrayInputStream(inputStr.getBytes(UTF_8)));
    }
}