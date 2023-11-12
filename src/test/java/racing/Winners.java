package racing;

import java.util.List;

public class Winners {

    List<Car> winners;

    private Winners(List<Car> winners) {
        this.winners = winners;
    }

    public static Winners defaultOf(List<Car> winners) {
        return new Winners(winners);
    }

    @Override
    public String toString() {
        return "Winners{" +
                "winners=" + winners +
                '}';
    }
}
