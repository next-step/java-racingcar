package race.view;

import java.util.Scanner;

public class InputView {

    private final static Scanner SCANNER = new Scanner(System.in);

    public String askNameOfCar() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return SCANNER.nextLine();
    }

    public int askNumberOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCars = SCANNER.nextInt();
        if (numberOfCars < 0) {
            throw new IllegalArgumentException(String.format("(%d)은/는 음수입니다.", numberOfCars));
        }
        return numberOfCars;
    }

    public int askNumberOfAttempts() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int attempts = SCANNER.nextInt();
        if (attempts < 0) {
            throw new IllegalArgumentException(String.format("(%d)은/는 음수입니다.", attempts));
        }
        return attempts;
    }

}
