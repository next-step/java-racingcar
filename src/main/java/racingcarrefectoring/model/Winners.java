package racingcarrefectoring.model;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private final List<Winner> winners = new ArrayList<>();

    public void addWinner(Name winnerName){
        winners.add(new Winner(winnerName));
    }

    public Winner getWinner(int index){
        return winners.get(index);
    }

    public int getWinnersCount(){
        return winners.size();
    }

    public void winnersClear(){
        winners.clear();
    }
}
