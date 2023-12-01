package racingCar.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputView {

    private InputView(){}

    public static int[] input() {
        int[] inputValues = new int[2];

        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        inputValues[0] = scanner.nextInt();

        System.out.println("시도할 횟수는 몇 회 인가요?");
        inputValues[1] = scanner.nextInt();

        return inputValues;
    }

    public static Map<String, Object> winnerInput(){
        Map<String, Object> inputValues = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        inputValues.put("carNames", scanner.nextLine());

        System.out.println("시도할 횟수는 몇 회 인가요?");
        inputValues.put("tryNum", scanner.nextInt());

        return inputValues;
    }
}
