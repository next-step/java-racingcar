package racingcar;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputView {
    public RacingDTO setRacingInfo(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String inputName = scanner.nextLine();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int attempts = scanner.nextInt();

        return RacingDTO.of(inputName, attempts);
    }
}