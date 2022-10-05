package step3and4.client.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputView implements InputView {

    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public int answerToQuestion(String question) throws IOException {
        verifyOnlyNumber(question);

        System.out.println(question);
        return Integer.parseInt(BUFFERED_READER.readLine());
    }

    @Override
    public String[] carsNames(String question) throws IOException {
        System.out.println(question);
        return BUFFERED_READER.readLine()
                .split(",");
    }

    private void verifyOnlyNumber(String question) {
        if (question.matches("\\D")) {
            throw new IllegalArgumentException("숫자만 들어올 수 있습니다.");
        }
    }

}
