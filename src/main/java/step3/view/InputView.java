package step3.view;

import step3.model.Message;

import java.util.Scanner;

public class InputView {

    /**
     * 입력값이 숫자인지 아닌지 판단한다.
     * @param input
     * @return
     */
    public static boolean isDigit(String input) {
        if (input == null || input.trim().length() > 0) {
            return input.matches("[0-9]*");
        }

        return false;
    }

    /**
     * 자동차대수와 시도횟수를 입력받는다.
     * @param category
     * @return
     */
    public int ask(Message category) {
        int cnt = 0; //자동차대수 or 시도횟수

        while (cnt <= 0) {
            //입력받기
            Scanner sc = new Scanner(System.in);
            System.out.println(category.getInputMessage());
            String userInput = sc.nextLine();

            //숫자가 아닐경우 예외처리
            if (!isDigit(userInput)) {
                System.out.println("숫자로 입력해주세요.");
                continue;
            }

            cnt = Integer.parseInt(userInput);
            //0개 이상일 경우
            if (cnt > 0) {
                System.out.println("입력되었습니다.");
                return cnt;
            }

            //0개 이하 예외처리
            System.out.println(category.getErrorMessage());
        }

        return cnt;
    }
}
