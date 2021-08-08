package stage3;

import java.util.Scanner;

public class InputView {

    private Scanner sc;

    public InputView() {
        this.sc = new Scanner(System.in);
    }
    public InputValue input() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNum = sc.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryNum = sc.nextInt();
        System.out.println();
        return new InputValue(carNum, tryNum);
    }
}
