package study.step4;

import study.step4.dto.RacingInput;

import java.util.Scanner;

public class InputView {

    public RacingInput enter(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carNames = scanner.next().split(",");
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryNum = scanner.nextInt();

        return new RacingInput(carNames, tryNum);

    }
}
