package study;

import java.util.List;

public class GameInfo {
    private List<String> nameList;
    private int numberOfGame;

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
