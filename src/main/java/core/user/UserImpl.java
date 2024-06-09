package core.user;

import java.util.List;
import java.util.Scanner;

public class UserImpl implements UserInterface {

  @Override
  public String getCarNames() {
    String userCarNamesCmd = null;
    do {
      System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
      Scanner sc = new Scanner(System.in);
      userCarNamesCmd = sc.nextLine();
    } while(isUserCarNameCmdValidate((userCarNamesCmd)));

    return null;
  }

  @Override
  public Boolean isUserCarNameCmdValidate(String userCarNamesCmd) {
    Boolean result = null;

    return result;
  }

  @Override
  public List<String> parseCarNames(String userCarNamesCmd) {
    return null;
  }
}
