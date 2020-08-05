package step03.util;

import java.util.Scanner;

/**
 * Project : java-racingcar
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 11:16 오후
 */
public class Util {

    public static String howManyCars = "자동차 대수는 몇 대 인가요?";
    public static String howMuchTry = "시도할 회수는 몇 회 인가요?";
    public static String result = "실행결과";
    public static String moveStirng = "-";

    public static Scanner input() {
        return new Scanner(System.in);
    }
}
