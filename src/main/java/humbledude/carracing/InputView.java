package humbledude.carracing;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public List<String> getNamesOfCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();
        return Arrays.asList(input.split(","));
    }

    @Deprecated
    public int getNumberOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public int getNumberOfTurns() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
