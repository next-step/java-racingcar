package racingcar;

import lombok.Data;

import java.util.Scanner;

@Data
public class InputView {
    private Scanner scanner = new Scanner(System.in);
    private String[] carNames;
    private String numOfTries;

    public UserInput getRacingInfo() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        carNames = scanner.nextLine().split(",");
        System.out.println("시도할 회수는 몇 회 인가요?");
        numOfTries = scanner.nextLine();

        return new UserInput(carNames, numOfTries);
    }
}
