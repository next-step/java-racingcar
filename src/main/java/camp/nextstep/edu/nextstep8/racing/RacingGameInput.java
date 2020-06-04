package camp.nextstep.edu.nextstep8.racing;

import java.util.Scanner;

public class RacingGameInput {
    private static final Scanner SCANNER = new Scanner(System.in);

    public String getCars() {
        System.out.print("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분 ");
        if(SCANNER.hasNextLine()) {
            return SCANNER.next().trim();
        }
        throw new IllegalArgumentException("입력된 자동자 이름이 없습니다");
    }

    public int getRoundTimes() {
        System.out.print("시도할 회 수는 몇 회 인가요? ");
        if(SCANNER.hasNextInt()) {
            return SCANNER.nextInt();
        }
        throw new IllegalArgumentException("숫자를 입력해 주세요");
    }
}
