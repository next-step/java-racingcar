package racingcar.step3.view;

import racingcar.step3.common.Consts;
import racingcar.step3.common.Scan;

import java.util.Scanner;

/**
 * Created : 2020-11-02 오전 8:25.
 * Developer : Seo.
 */
public class InputView {
    Scanner scanner;

    public String getInputCars() {
        this.scanner = Scan.getInstance();
        System.out.println(Consts.HOW_MANY_CARS);
        return scanner.next();
    }

    public int getInputTurns() {
        this.scanner = Scan.getInstance();
        System.out.println(Consts.HOW_MANY_ATTEMPTS);
        return scanner.nextInt();
    }
}
