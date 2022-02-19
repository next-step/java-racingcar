package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    private static final String CAR_NAME_INPUT_HELP_TEXT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_NUMBER_INPUT_HELP_TEXT = "시도할 횟수는 몇회인가요?";
    private static final String IO_EXCEPTION_HELP_TEXT = "다시 입력해주세요.";
    public static final String TRY_NUMBER_FORMAT_EXCEPTION_HELP_TEXT = "횟수가 숫자의 형식이 아닙니다. 다시 입력해주세요";

    public static String getCarNames() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(CAR_NAME_INPUT_HELP_TEXT);
        try {
            return br.readLine();
        } catch (IOException e) {
            System.out.println(IO_EXCEPTION_HELP_TEXT);
            return getCarNames();
        }
    }

    public static int getTryNo() {
        System.out.println(TRY_NUMBER_INPUT_HELP_TEXT);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            return Integer.parseInt(br.readLine());
        } catch (NumberFormatException nfe) {
            System.out.println(TRY_NUMBER_FORMAT_EXCEPTION_HELP_TEXT);
            return getTryNo();
        } catch (IOException e) {
            System.out.println(IO_EXCEPTION_HELP_TEXT);
            return getTryNo();
        }
    }
}
