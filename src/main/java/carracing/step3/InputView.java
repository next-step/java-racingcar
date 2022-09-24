package carracing.step3;

import java.util.Scanner;

public class InputView {

    public int enterCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        return this.parseCount(scanner.nextLine());
    }

    public int enterTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        Scanner scanner = new Scanner(System.in);
        return this.parseCount(scanner.nextLine());
    }

    private int parseCount(String count) {
        int parsedCount;
        try {
            parsedCount = Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("잘못된 숫자를 입력하였습니다.");
        }
        return parsedCount;
    }

}
