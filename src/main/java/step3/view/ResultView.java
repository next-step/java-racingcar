package step3.view;

import step3.view.dto.GameResultDto;

import static java.lang.System.out;

public class ResultView {

    private static final String START = "[START]";
    private static final String END = "[END]";


    public void printResult(GameResultDto gameResultDto) {
        show(START);
        show(gameResultDto.toString());
        show(END);
    }

    private void show(String output) {
        out.println(output);
    }
}
