package carRacing.view;

import java.util.Scanner;

public class InputView {
    private String carNamesString;
    private Integer tryCount;

    public InputView() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNameString = scanner.nextLine();
        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = scanner.nextInt();

        this.carNamesString = carNameString;
        this.tryCount = tryCount;
    }

    public String getCarNamesString() {
        return carNamesString;
    }

    public Integer getTryCount() {
        return tryCount;
    }


}
