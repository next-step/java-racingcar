package racing.view;

import racing.domain.dto.GameRequest;
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
            throw new InvalidInputException("숫자만 입력 해주세요.");

        return Integer.parseInt(input);
    }

    private String inputLine(Text guideText) {
        System.out.println(guideText.toString());

        return scanner.nextLine();
    }

    @Override
    public GameRequest inputGameRequest() {
        String carNames = inputLine(INPUT_CAR_NAMES);
        int turnSize = inputNumber(INPUT_TURN_SIZE);
        return new GameRequest(carNames, turnSize);
    }

    protected enum Text {
        INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요 (이름은 ','를 기준으로 구분)."),
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
