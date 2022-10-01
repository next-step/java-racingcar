package step3.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputView implements InputView {

    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public int answerToQuestion(String question) throws IOException {
        System.out.println(question);
        return Integer.parseInt(BUFFERED_READER.readLine());
    }

}
