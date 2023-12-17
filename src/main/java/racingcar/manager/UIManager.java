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

    public Integer showCarCount(){
        UIInGame.printCarCountInput();
        return Input.setInputValue();
    }

    public Integer showRoundCount(){
        UIInGame.printRoundInput();
        return Input.setInputValue();
    }
}
