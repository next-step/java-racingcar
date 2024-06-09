package core.user;

import java.util.List;

public interface UserInterface {
  String getCarNames();

  Boolean isUserCarNameCmdValidate(String userCarNamesCmd);

  List<String> parseCarNames(String userCarNamesCmd);
}
