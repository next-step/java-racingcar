package racingCar;

import java.util.HashMap;
import java.util.Map;

public class Ready {
    private static final String SPLIT_VALUE = ",";

    public String[] splitNameByComma(String carName) {
        return carName.split(SPLIT_VALUE);
    }

    public boolean isGreaterThanFive(int number) {
        return number > 5;
    }

    public String checkNameLength(String carName) {
        if (isGreaterThanFive(carName.length())) {
            throw new IllegalArgumentException("자동차 이름의 길이가 5를 초과합니다.");
        }
        return carName;
    }

     public String[] createPlayerListByName(String carName) {
        String[] PlayerList = splitNameByComma(carName);

        for (int i = 0; i < PlayerList.length; i++) {
            PlayerList[i] = checkNameLength(PlayerList[i]);
        }
        return PlayerList;
    }

    public static Map<String, String> createScoreTableByPlayerList(String[] playerList) {
        Map<String, String> scoreTable = new HashMap<>();
        for (String s : playerList) {
            scoreTable.put(s, "");
        }
        return scoreTable;
    }

}
