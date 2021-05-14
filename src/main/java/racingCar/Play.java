package racingCar;

import java.util.HashMap;
import java.util.Map;

public class Play {

    public static Map<String, String> OneRoundGame() {
        Input input = new Input();
        Ready ready = new Ready();
        Function function = new Function();

        // input
        String name = input.carName();
        System.out.println(name);

        // ready
        String[] PlayerList = ready.createPlayerListByName(name);
        HashMap<String, String> scoreTable;
        scoreTable = (HashMap<String, String>) Ready.createScoreTableByPlayerList(PlayerList);
        String score;

        // 1 Round play game
        System.out.println("실행결과");
        for (String s : PlayerList) {
            int randomNumber = function.drawNumber();
            Boolean movable = function.moveAble(randomNumber);
            score = scoreTable.get(s) + function.getScore(movable);

            scoreTable.put(s, score);
            System.out.println(s + ":" + score);
        }
        return scoreTable;
    }

    public static void main(String[] args) {
        Map<String, String> oneRoundGame = OneRoundGame();
        System.out.println(oneRoundGame);
    }
}
