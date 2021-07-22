package racing.view;

import racing.view.request.ActionRequest;
import util.StringUtils;

import java.util.Optional;
import java.util.Scanner;

import static racing.view.DosInputView.Text.*;

public class DosInputView implements InputView {
    private Scanner scanner;

    public DosInputView() {
        this.scanner = new Scanner(System.in);
    }

    private int inputNumber(Text guideText) {
        String input = inputLine(guideText);
        if (!StringUtils.isNumber(input)) {
            return inputNumber(guideText);
        }
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
    public ActionRequest inputAction() {
        int turnSize = inputNumber(INPUT_TURN_SIZE);
        Optional<InputAction> action;
        do {
            action = InputAction.of(
                    inputLine(INPUT_ACTION)
            );
        } while(!action.isPresent());
        return new ActionRequest(action.get(), turnSize);
    }

    protected enum Text {
        INPUT_CAR_SIZE("자동차 대수는 몇 대 인가요?"),
        INPUT_TURN_SIZE("시도할 회수는 몇 회 인가요?"),
        INPUT_ACTION("자동차를 움직일까요? (Y/N)\n종료를 원하시면 Q를 입력 해주세요."),
        NOT_NUMBER("숫자만 입력 해주세요.");

        private String text;

        Text(String text) {
            this.text = text;
        }

        public String formatString(Object... objs) {
            return String.format(text, objs);
        }

        @Override
        public String toString() {
            return text;
        }
    }
}
