package racingcar.view;

import java.util.Scanner;

public class InputView {

  public static String CAR_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표 및 띄어쓰기로 기준)";
  public static String ATTEMPT_INPUT_MESSAGE = "시도할 회수는 몇 회인가요?";

  public static Integer getUserNumInput() {
    System.out.println(ATTEMPT_INPUT_MESSAGE);
    Scanner scanner = new Scanner(System.in);
    return scanner.nextInt();
  }


  public static String getUserStringInput() {
    System.out.println(CAR_INPUT_MESSAGE);
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }
}
