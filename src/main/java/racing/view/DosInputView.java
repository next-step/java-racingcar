package racing.view;

import util.StringUtils;

import java.util.Scanner;

public class DosInputView implements InputView {
    private Scanner scanner;

    public DosInputView() {
        this.scanner = new Scanner(System.in);
    }

    private int inputNumber(Text guideText) {
        System.out.println(guideText.toString());

        String input = scanner.nextLine();
        if (!StringUtils.isNumber(input)) {
            System.out.println(Text.NOT_NUMBER);
            return inputNumber(guideText);
        }
        return Integer.parseInt(input);
    }

    @Override
    public int inputCarSize() {
        return inputNumber(Text.INPUT_CAR_SIZE);
    }

    @Override
    public int inputTurnSize() {
        return inputNumber(Text.INPUT_TURN_SIZE);
    }

    private enum Text {
        INPUT_CAR_SIZE("자동차 대수는 몇 대 인가요?"),
        INPUT_TURN_SIZE("시도할 회수는 몇 회 인가요?"),
        NOT_NUMBER("숫자만 입력 해주세요.");

        private String text;

        Text(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }
}
