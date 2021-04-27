package jung;

import java.util.ArrayList;
import java.util.Scanner;

public class CarName {
    Scanner scann = new Scanner(System.in);
    String[] names;

    /**
     * 자동차 이름 글자수 판별
     */
    boolean isCarLength(String[] names) {
        for (String name : names) {
            if (name.length() >= 5) {
                return false;
            }
        }
        return true;
    }

    /**
     * 자동차 이름 메서드
     */

    String[] car_name() {
        boolean isWhile = true;

        while (isWhile) {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            names = scann.nextLine().replaceAll(" ", "").split(",");
            if (isCarLength(names)) {
                isWhile=false;
            }
        }
        return names;
    }
}
