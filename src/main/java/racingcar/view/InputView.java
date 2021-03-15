package racingcar.view;

import racingcar.Constant;
import racingcar.util.StringUtil;
import racingcar.util.ValidationUtil;

import java.util.Scanner;


public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String[] playCarName() {
        String name = null;
        String[] names;

        do {
            System.out.println(Constant.INPUT_REQUEST_CAR_NAME);
            name = scanner.next();
            names = StringUtil.splitInput(name);
        } while (!ValidationUtil.isNmaeCheck(names));

        return names;
    }

    public static int tryGameNum() {
        String count = null;
        do {
            System.out.println(Constant.INPUT_REQUEST_PLAY_COUNT);
            count = scanner.next();
        } while (!ValidationUtil.isNumber(count));

        return Integer.parseInt(count);
    }


}
