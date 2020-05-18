/*
 *
 *
 *
 */

package study.racing.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int scanIntWithQuestion(String question) {
        int answer;

        System.out.println(question);

        try {
            answer = scanner.nextInt();
        } catch(InputMismatchException e) {
            scanner.nextLine();     // 버퍼에서 개행문자 제거
            System.out.println("숫자만 입력 가능합니다. 다시 입력해주세요.");

            return scanIntWithQuestion(question);
        }

        return answer;
    }


}
