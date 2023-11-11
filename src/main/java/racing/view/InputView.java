package racing.view;

import racing.domain.RaceInfo;

import java.util.Scanner;

public class InputView {

    public static final String DELIMITER = ",";

    public RaceInfo inputNameInfo() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        String[] names = splitNames(scanner);

        System.out.println("시도할 횟수는 몇 회 인가요?");
        int trials = scanner.nextInt();

        System.out.println("\n실행 결과");

        return new RaceInfo(names, trials);
    }

    private String[] splitNames(Scanner scanner) {
        String inputNames = scanner.nextLine();
        return inputNames.split(DELIMITER);
    }

}
