package racingcar.manager;

import racingcar.Main;
import racingcar.ui.UIInGame;
import racingcar.ui.UIIntro;
import racingcar.util.Input;

public class UIManager {

	public static int showIntro() {
		UIIntro.printIntro();
		return checkValidIntroInputNum();
	}

	private static int checkValidIntroInputNum() {
		int programStatus = Input.setInputValue();
		if (programStatus == 1) {
			return programStatus;
		}
		if (programStatus == 2) {
			SecurityManager.checkExit(programStatus);
			return programStatus;
		}
		UIIntro.printException();
		String[] args = new String[0];
		Main.main(args);
		return programStatus;
	}

	public static String[] showCarNames() {
		UIInGame.printCarCountInput();
		return Input.setInputNames();
	}

	public static Integer showRoundCount() {
		UIInGame.printRoundInput();
		return Input.setInputValue();
	}
}
