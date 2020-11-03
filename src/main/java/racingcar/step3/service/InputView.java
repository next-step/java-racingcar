package racingcar.step3.service;

import racingcar.step3.common.Consts;
import racingcar.step3.common.Scan;

import java.util.Scanner;

/**
 * Created : 2020-11-02 오전 8:25
 * Developer : Seo
 */
public class InputView {
    private int cars;
    private int turns;
    Scanner scanner;

    public void setCars() {
        this.scanner = Scan.getInstance();
        System.out.println(Consts.HOW_MANY_CARS);
        this.cars = scanner.nextInt();
    }

    public int getCars() {
        return this.cars;
    }

    public void setTurns() {
        this.scanner = Scan.getInstance();
        System.out.println(Consts.HOW_MANY_ATTEMPTS);
        this.turns = scanner.nextInt();
    }

    public int getTurns() {
        return this.turns;
    }

}
