package study.domain;

import java.util.List;

public class GameInfo {
    private final List<String> nameList;
    private final int numberOfGame;

    public GameInfo(List<String> nameList, int numberOfGame) {
        this.nameList = nameList;
        this.numberOfGame = numberOfGame;
    }


    public List<String> getNameList() {
        return this.nameList;
    }

    public int getNumberOfGame() {
        return numberOfGame;
    }
}
