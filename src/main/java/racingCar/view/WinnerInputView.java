package racingCar.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WinnerInputView {

    private WinnerInputView(){}

    public static Map<String, Object> input(){
        Map<String, Object> inputValues = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        inputValues.put("carNames", scanner.nextLine());

        System.out.println("시도할 횟수는 몇 회 인가요?");
        inputValues.put("tryNum", scanner.nextInt());

        return inputValues;
    }
}
