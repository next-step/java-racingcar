package racing.view;

import java.util.Random;
import java.util.Scanner;

/** 
 * View 전용 입력 관리 클래스
 * 인스턴스가 생성되는 것을 막기 위해 static method들로만 구성함
 */
public class InputView {
  private static Scanner scanner;

  private InputView(){
    scanner = new Scanner(System.in);
  }

  public static int inputCarCount(){
    System.out.println("자동차의 대수는 몇 대 인가요?");
    return scanner.nextInt();
  }

  public static int inputPeriod(){
    System.out.println("시도할 회수는 몇 회 인가요?");
    return scanner.nextInt();
  }
}
