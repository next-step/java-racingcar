package step4.service.dto;

import step4.view.UserInput;
import step4.vo.Names;

public class GameInformation {

    private final Names names;
    private final Integer time;

    private GameInformation(Names names, Integer time) {
        this.names = names;
        this.time = time;
    }

    public static GameInformation create(UserInput userInput) {
        Names names = new Names();
        names.addNames(userInput.getNames());
        Integer time = Integer.parseInt(userInput.getTimeStr());
        return new GameInformation(names, time);
    }

    public static GameInformation create(String namesStr, Integer time) {
        Names names = new Names();
        names.addNames(namesStr);
        return new GameInformation(names, time);
    }

    public Names getNames() {
        return names;
    }

    public Integer getTime() {
        return time;
    }
}
