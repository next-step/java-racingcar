package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public abstract class IOTest {
    private ByteArrayOutputStream outputStreamCaptor;
    private PrintStream standardOut; // 표준 스트림

    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @BeforeEach
    void setUp() {
        standardOut = System.out; // 표준 스트림 초기화
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    protected void printResult() {
        System.setOut(standardOut); // 표준 스트림 할당
        System.out.println(getOutput()); // 원하는 내용이 잘 나왔는지 문자열 디코딩 바이트를 가져와 출력
    }

    protected String getOutput() {
        return outputStreamCaptor.toString();
    }
}
