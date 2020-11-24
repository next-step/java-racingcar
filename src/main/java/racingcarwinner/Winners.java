package racingcarwinner;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private final List<Winner> winners = new ArrayList();

    public Winner getWinner(int index){
        return winners.get(index);
    }

    public void addWinner(String name){
        winners.add(new Winner(name));
    }

    public int getCount() {
        return winners.size();
    }

    public void clearWinners(){
        winners.clear();
    }

}
