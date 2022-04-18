package racingcar_step4;

import java.util.Scanner;

public class InputView {

    private static Scanner sc = new Scanner(System.in);


    //값만 받아서 값을 묶어서 리턴해줌.
    public static InputValue input() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carsString = sc.nextLine();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryNum = sc.nextInt();
        return new InputValue(carsString, tryNum);
    }
}
