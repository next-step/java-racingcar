package racingcar.step3.common;

import java.util.Scanner;

/**
 * Created : 2020-11-03 오전 8:40.
 * Developer : Seo.
 */
public class Scan {
    static Scanner instance;

    private Scan() {
    }

    public static Scanner getInstance() {
        if (instance == null) {
            instance = new Scanner(System.in);
        }
        return instance;
    }

}
