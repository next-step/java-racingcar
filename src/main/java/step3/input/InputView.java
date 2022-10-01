package step3.input;

import java.io.IOException;

@FunctionalInterface
public interface InputView {

    int answerToQuestion(String question) throws IOException;

}
