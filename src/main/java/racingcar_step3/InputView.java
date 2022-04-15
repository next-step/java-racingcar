package racingcar_step3;

import java.util.Scanner;

public class InputView {

    private static Scanner sc = new Scanner(System.in);


    //값만 받아서 값을 묶어서 리턴해줌.
    public static InputValue input() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNum = sc.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryNum = sc.nextInt();
        return new InputValue(carNum, tryNum);
    }
}
