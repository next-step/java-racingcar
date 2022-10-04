package step3and4.client.input;

import java.io.IOException;

@FunctionalInterface
public interface InputView {

    int answerToQuestion(String question) throws IOException;

}
