package racingcar;

import java.util.List;

public class Winner {

    private final String NO_WINNER = "";
    private final int NO_WINNER_LENGTH = 0;

    public String whoisWin(List<RacingCar> carList, GameSet gameSet) {
        String names = "";

        for (int i = 0; i < carList.size(); i++) {
            names += winner(carList.get(i), gameSet);
        }

        return names;
    }

    private String winner(RacingCar racingCar, GameSet gameSet) {
        if (racingCar.status().length() == gameSet.getGivenRound()) {
            return racingCar.getOwner() + ",";
        }
        return NO_WINNER;
    }

    public void showResult(String name) {

        String result = "";

        if (name.length() == NO_WINNER_LENGTH) {
            System.out.println(result);
        }

        char lastChar = name.charAt(name.length()-1);

        if (lastChar == ',') {
            result = name.replaceFirst(".$", "") + "가 최종 우승했습니다.";
        }

        System.out.println(result);
    }
}
