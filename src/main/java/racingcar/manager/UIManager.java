package racingcar.manager;

import java.util.Arrays;
import java.util.List;

import racingcar.Main;
import racingcar.ui.UIInGame;
import racingcar.ui.UIIntro;
import racingcar.util.Input;

public class UIManager {

	public static int showIntro() {
		UIIntro.printIntro();
		return validatedIntroInputNum();
	}

	private static int validatedIntroInputNum() {
		int programStatus = Input.inputValue();
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

	public static List<String> carNames() {
		UIInGame.printCarNamesInput();
		return Arrays.asList(Input.inputNames());
	}

	public static Integer roundCount() {
		UIInGame.printRoundInput();
		return Input.inputValue();
	}
}