package racing.view;

import java.util.Scanner;
import racing.domain.Cars;

public class InputView {

    private String carNames;
    private int tryCount;

    public InputView(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        carNames = scanner.nextLine();
        System.out.println("시도할 회수는 몇 회 인가요?");
        tryCount = scanner.nextInt();
    }

    public Cars getCarNames() {
        return new Cars(carNames.split(","));
    }

    public int getTryCount() {
        return tryCount;
    }
}
