package racingcar.view;
import racingcar.Constant;
import racingcar.util.StringUtil;
import racingcar.util.ValidationUtil;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String[] playCarName(){
        String name = null;
        ValidationUtil validationUtil = new ValidationUtil();
        do {
            System.out.println(Constant.INPUT_REQUEST_CAR_NAME);
            name = scanner.next();
        } while(!validationUtil.isNmaeCheck(name));
        return StringUtil.splitInput(name);
    }

    public static int tryGameNum(){
        String count = null;
        ValidationUtil validationUtil = new ValidationUtil();
        do {
            System.out.println(Constant.INPUT_REQUEST_PLAY_COUNT);
            count = scanner.next();
        } while(!validationUtil.isNumber(count));

        return Integer.parseInt(count);
    }


}
