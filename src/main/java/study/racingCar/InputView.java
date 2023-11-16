package study.racingCar;

import java.util.Scanner;

public class InputView {

    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String inputCarNames(){
        String carName = "";
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        carName = scanner.nextLine();
        return carName;
    }

    public String inputTryCount(){
        String tryCount = "";
        System.out.println("시도할 회수는 몇회인가요?");
        tryCount = scanner.nextLine();
        return tryCount;
    }
}
