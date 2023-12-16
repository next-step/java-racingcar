package racingcar.manager;

import racingcar.ui.UIInGame;
import racingcar.ui.UIIntro;
import racingcar.util.Input;

import java.util.ArrayList;
import java.util.List;

public class UIManager {
    UIIntro intro = new UIIntro();
    UIInGame inGame = new UIInGame();
    Input input = new Input();
    SecurityManager securityManager = new SecurityManager();
    public int showIntro(){
        intro.printIntro();
        return checkValidIntroInputNum();
    }
    private int checkValidIntroInputNum() {
        int programStatus = input.setInputValue();
        if (programStatus == 1){
            return programStatus;
        }
        if (programStatus == 2){
            securityManager.checkExit(programStatus);
            return programStatus;
        }
        intro.printException();
        return programStatus;
    }
    public List<Integer> showStartInGame() {
        List<Integer> startInGameInput = new ArrayList<>();
        inGame.printPlayerCountInput();
        startInGameInput.add(input.setInputValue());
        inGame.printRoundInput();
        startInGameInput.add(input.setInputValue());
        return startInGameInput;
    }
}
