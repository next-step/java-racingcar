package car.view;

import java.util.Scanner;

public class InputView {

    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int playNumberScanner(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        return scanner.nextInt();
    }

    public String carNameScanner(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.next();
    }
}
