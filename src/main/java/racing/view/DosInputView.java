package racing.view;

import racing.exception.InvalidInputException;
import util.StringUtils;

import java.util.Scanner;

import static racing.view.DosInputView.Text.*;

public class DosInputView implements InputView {
    private final Scanner scanner;

    public DosInputView() {
        this.scanner = new Scanner(System.in);
    }

    private int inputNumber(Text guideText) {
        String input = inputLine(guideText);
        if (!StringUtils.isNumber(input))
            throw new InvalidInputException();
        return Integer.parseInt(input);
    }

    private String inputLine(Text guideText) {
        System.out.println(guideText.toString());

        return scanner.nextLine();
    }

    @Override
    public int inputCarSize() {
        return inputNumber(INPUT_CAR_SIZE);
    }

    @Override
    public int inputTurnSize() {
        return inputNumber(INPUT_TURN_SIZE);
    }

    protected enum Text {
        INPUT_CAR_SIZE("자동차 대수는 몇 대 인가요?"),
        INPUT_TURN_SIZE("시도할 회수는 몇 회 인가요?");

        private final String text;

        Text(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }
}
