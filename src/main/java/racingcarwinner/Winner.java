package racingcarwinner;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private static List<String> winners = new ArrayList<>();

    public static void addWinner(String winnerName){
        winners.add(winnerName);
    }

    public static int winnerCount(){
        return winners.size();
    }

    public static String getWinner(int index){
        return winners.get(index);
    }

    public static void clearWinner(){
        winners.clear();
    }
}
