package step4.view;

import step4.util.MsgConstants;

import java.util.Scanner;

/** 
 * View 전용 입력 관리 클래스
 * 인스턴스가 생성되는 것을 막기 위해 static method들로만 구성함
 */
public class InputView {
  private Scanner scanner;

  public InputView(){
    scanner = new Scanner(System.in);
  }

  public String inputCarNames(){
    System.out.println(MsgConstants.INPUT_REQUIRE_CAR.getMessage());
    return scanner.nextLine();
  }

  public int inputPeriod(){
    System.out.println(MsgConstants.INPUT_REQUIRE_ATTEMPT.getMessage());
    return scanner.nextInt();
  }
}
