package racingcar.manager;

import racingcar.Main;
import racingcar.ui.UIInGame;
import racingcar.ui.UIIntro;
import racingcar.util.Input;

import java.util.ArrayList;
import java.util.List;

public class UIManager {

    public int showIntro(){
        UIIntro.printIntro();
        return checkValidIntroInputNum();
    }

    private int checkValidIntroInputNum() {
        int programStatus = Input.setInputValue();
        if (programStatus == 1){
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

    public List<Integer> showStartInGame() {
        List<Integer> startInGameInput = new ArrayList<>();
        UIInGame.printPlayerCountInput();
        startInGameInput.add(Input.setInputValue());
        UIInGame.printRoundInput();
        startInGameInput.add(Input.setInputValue());
        return startInGameInput;
    }
}
