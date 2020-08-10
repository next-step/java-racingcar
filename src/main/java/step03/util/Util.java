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

    private Util() throws IllegalAccessException {
        throw new IllegalAccessException();
    }
    public static String WHATYOURNAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static String HOWMANYCAR = "자동차 대수는 몇 대 인가요?";
    public static String HOWMUCHTRY = "시도할 회수는 몇 회 인가요?";
    public static String RESULT = "실행결과";
    public static String MOVESTRING = "-";

    public static Scanner input() {
        return new Scanner(System.in);
    }
}
