package racing.view;

import java.util.Scanner;

public class InputView {

  public static final String GET_NAMES_OF_RACING_CARS_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
  public static final String GET_NUMBER_OF_CHANCE_MESSAGE = "시도할 횟수는 몇 회 인가요?";

  public static final Scanner input = new Scanner(System.in);

  public static String getNumberOfRacingCar() {
    System.out.println(GET_NAMES_OF_RACING_CARS_MESSAGE);
    return input.next();
  }

  public static int getNumberOfChance() {
    System.out.println(GET_NUMBER_OF_CHANCE_MESSAGE);
    return input.nextInt();
  }
}
