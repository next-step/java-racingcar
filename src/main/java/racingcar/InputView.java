package racingcar;

import lombok.Data;

import java.util.Scanner;

@Data
public class InputView {
    private Scanner scanner = new Scanner(System.in);
    private String numOfCars;
    private String numOfTries;

    public UserInput getRacingInfo() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        numOfCars = scanner.nextLine();
        System.out.println("시도할 회수는 몇 회 인가요?");
        numOfTries = scanner.nextLine();

        return new UserInput(numOfCars, numOfTries);
    }
}
