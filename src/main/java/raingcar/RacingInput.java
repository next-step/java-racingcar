package raingcar;

import java.util.Scanner;

public class RacingInput {
    private Scanner scan;
    public RacingInput () {
        scan = new Scanner(System.in);
    }

    public String getCars() {
        System.out.println("자동차 명을 입력하세요. ',' 구분자로 입력하세요.");
        String    carNames = scan.nextLine();
        return carNames;
    }

    public int getRap() {
        System.out.println("레이싱 횟수를 입력하세요.");
        int    rap = scan.nextInt();
        return rap;
    }
}
