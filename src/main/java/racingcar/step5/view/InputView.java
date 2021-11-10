package racingcar.step5.view;

import java.util.Scanner;

import static racingcar.step5.message.ViewMessage.NAME_INPUT_MESSAGE;
import static racingcar.step5.message.ViewMessage.TRY_INPUT_MESSAGE;

public class InputView {

    private final Scanner sc = new Scanner(System.in);

    public String getCarName() {
        System.out.println(NAME_INPUT_MESSAGE);
        return sc.nextLine();
    }

    public int countOfTry() {
        System.out.println(TRY_INPUT_MESSAGE);
        return sc.nextInt();
    }

}
