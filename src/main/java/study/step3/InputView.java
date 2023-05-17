package study.step3;

import study.step3.dto.Input;

import java.util.Scanner;

public class InputView {

    public Input enter(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNum = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryNum = scanner.nextInt();

        return new Input(carNum, tryNum);

    }
}
