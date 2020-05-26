/*
 *
 *
 *
 */

package study.racing.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final String CAR_NAME_QUESTION = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)를 기준으로 구분)";
    private static final String TIME_QUESTION = "시도할 회수는 몇회인가요?";
    private static final String CAR_NAME_DELIMITER = ",";

    private Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public String[] scanCarNames() {
        String answer;

        System.out.println(CAR_NAME_QUESTION);

        try {
            answer = scanner.nextLine();
        } catch(InputMismatchException e) {
            scanner.nextLine();     // 버퍼에서 개행문자 제거
            System.out.println("문자만 입력 가능합니다. 다시 입력해주세요.");

            return scanCarNames();
        }

        return answer.split(CAR_NAME_DELIMITER);
    }

    public int scanTime() {
        int answer;

        System.out.println(TIME_QUESTION);

        try {
            answer = scanner.nextInt();
        } catch(InputMismatchException e) {
            scanner.nextLine();     // 버퍼에서 개행문자 제거
            System.out.println("숫자만 입력 가능합니다. 다시 입력해주세요.");

            return scanTime();
        }

        return answer;
    }


}
