package racingcar.view;
import racingcar.Constant;
import racingcar.util.ValidationUtil;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);;
    }

    public int carNum(){
        String count = null;
        ValidationUtil validationUtil = new ValidationUtil();
        do {
            System.out.println(Constant.INPUT_REQUEST_CAR_COUNT);
            count = scanner.next();
        }while (!validationUtil.isNumber(count));
        return Integer.parseInt(count);
    }

    public int tryGameNum(){
        String count = null;
        ValidationUtil validationUtil = new ValidationUtil();
        do {
            System.out.println(Constant.INPUT_REQUEST_PLAY_COUNT);
            count = scanner.next();
        }while (!validationUtil.isNumber(count));

        return Integer.parseInt(count);
    }


}
