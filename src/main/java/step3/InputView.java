package step3;

import java.util.Scanner;

// 경주의 요구사항을 입력 받는다
public class InputView {

    public int repeat;
    public int num;

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇대인가요?");
        this.num = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        this.repeat = scanner.nextInt();
    }


}
