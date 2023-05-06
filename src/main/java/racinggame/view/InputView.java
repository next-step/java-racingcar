package racinggame.view;

import racinggame.common.constants.RexFormatConstants;
import racinggame.common.util.PrintUtils;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_CARS_NAME_TEXT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n";
    private static final String INPUT_MOVE_NUMBER_TEXT = "시도할 회수는 몇 회 인가요?";
    public static String[] inputCarsName() {
        PrintUtils.println(INPUT_CARS_NAME_TEXT);
        String carsName = scanner.nextLine();
        return getCars(carsName);
    }

    private static String[] getCars(String carsName) {
        return carsName.split(RexFormatConstants.CARS_NAME_REX_FORMAT_TEXT.getFormat());
    }

    public static int inputMoveCount() {
        PrintUtils.println(INPUT_MOVE_NUMBER_TEXT);
        return scanner.nextInt();
    }

}
