package racing.view;

import java.util.Scanner;

public class InputView {
  private static Scanner scanner = new Scanner(System.in);

  public static int requestNumberOfCar(){
    System.out.println("자동차 대수는 몇 대 인가요?");
    return isPositiveNumber(scanner.nextInt());
  }

  public static int requestNumberOfRound(){
    System.out.println("시도할 횟수는 몇 회 인가요?");
    return isPositiveNumber(scanner.nextInt());
  }

  private static int isPositiveNumber(int number){
    if(number<0){
      throw new IllegalArgumentException(String.format("음수를 사용할 수 없습니다. 입력 값 :[%s]", number));
    }
    return number;
  }

}
