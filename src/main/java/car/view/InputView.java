package car.view;

import car.dto.UserInput;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static UserInput receiveInput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNameStr = scanner.nextLine();
        String[] carNameList = carNameStr.split(",");
        if (isCarNamesInvalid(carNameList)) {
            throw new IllegalArgumentException("Enter at least one name");
        }
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int totalRound = scanner.nextInt();
        if (isTotalRoundInvalid(totalRound)) {
            throw new IllegalArgumentException("Total round must be positive");
        }

        System.out.println();
        System.out.println("실행 결과");
        return new UserInput(carNameList, totalRound);
    }

    private static boolean isCarNamesInvalid(String[] carName) {
        return carName.length <= 0;
    }

    private static boolean isTotalRoundInvalid(int input) {
        return input <= 0;
    }
}
