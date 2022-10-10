package racing.view;

import java.util.Scanner;

public class InputView {

  public static final String GET_NUMBER_OF_RACING_CAR_MESSAGE = "자동차 대수는 몇 대 인가요?";
  public static final String GET_NUMBER_OF_CHANCE_MESSAGE = "시도할 횟수는 몇 회 인가요?";

  public static final Scanner input = new Scanner(System.in);

  public static int getNumberOfRacingCar() {
    System.out.println(GET_NUMBER_OF_RACING_CAR_MESSAGE);
    return input.nextInt();
  }


  public static int getNumberOfChance() {
    System.out.println(GET_NUMBER_OF_CHANCE_MESSAGE);
    return input.nextInt();
  }
}
