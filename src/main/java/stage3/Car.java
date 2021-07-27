package stage3;

import java.util.Scanner;

public class Car {
    public void start() {
        printNotice("자동차 대수는 몇 대 인가요?");
        int numOfCars = input();
        printNotice("시도할 회수는 몇 회 인가요?");
        int numOfTries = input();
    }

    private void printNotice(String text) {
        System.out.println(text);
    }

    private int input() {
        Scanner sc = new Scanner(System.in);
        int result = sc.nextInt();
        validateInput(result);
        return result;
    }

    void validateInput(int input) {
        if (input < 0) throw new IllegalArgumentException("음수를 입력할 수 없습니다.");
    }
}
