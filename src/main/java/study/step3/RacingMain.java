package study.step3;

import java.util.Scanner;
import study.step3.controller.CarRaceController;
import study.step3.utils.MessageUtil;
import study.step3.view.InputView;

public class RacingMain {
  public static void main(String[] args) {
    System.out.println(MessageUtil.carNumberMessage);

    Scanner scanner = new Scanner(System.in);
    int carNumber = scanner.nextInt();

    System.out.println(MessageUtil.carTimesMessage);
    int times = scanner.nextInt();

    InputView inputView = new InputView(carNumber, times);

    CarRaceController carRaceController = new CarRaceController(inputView);
    carRaceController.start();
  }

}
