package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private List<Winner> winners = new ArrayList<>();

    public Winners(List<String> names){

        for (String name : names){
            this.winners.add(new Winner(name));
        }
    }

    public List<Winner> getWinners() {
        return winners;
    }
}
