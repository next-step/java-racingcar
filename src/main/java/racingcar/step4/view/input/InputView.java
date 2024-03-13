package racingcar.step4.view.input;

import racingcar.step4.utils.ConstUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public List<String> getParticipantsNameInput() {
        return getParticipantsNameUserInput(ConstUtils.PARTICIPANTS_NAME_HELP_MESSAGE);
    }

    public int getRoundCountInput() {
        return getRoundCountUserInput(ConstUtils.ROUNDS_NUMBER_HELP_MESSAGE);
    }

    private List<String> getParticipantsNameUserInput(String helpMessage) {
        System.out.println(helpMessage);

        String input = scanner.nextLine();
        return Arrays.stream(input.split(ConstUtils.NAME_SEPARATE_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private int getRoundCountUserInput(String helpMessage) {
        System.out.println(helpMessage);

        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            throw new NumberFormatException("값은 숫자만 입력할 수 있습니다.");
        }
    }
}
