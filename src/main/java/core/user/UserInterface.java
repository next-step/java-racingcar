package core.user;

import java.util.List;

public interface UserInterface {
  String getCarNames();

  Boolean isUserCarNameCmdValidate(String userCarNamesCmd);

  Boolean checkCarNameLength(List<String> carNames);

  Boolean checkComma(String uesrCarNamesCmd);

  List<String> parseCarNames(String userCarNamesCmd);
}
