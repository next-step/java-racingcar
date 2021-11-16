package Racing.view;

import Racing.type.RacingNumber;
import java.util.Scanner;

public class InputView {

  public InputModel scanInput() {
    System.out.println("자동차 대수는 몇 대 인가요?");
    Scanner scanner = new Scanner(System.in);
    int countOfCar = scanner.nextInt();

    System.out.println("시도할 회수는 몇 회 인가요?");
    int countOfStage = scanner.nextInt();

    RacingNumber countOfCar1 = new RacingNumber(countOfCar);
    RacingNumber countOfStage1 = new RacingNumber(countOfStage);
    return new InputModel(countOfCar1, countOfStage1);

  }

}
