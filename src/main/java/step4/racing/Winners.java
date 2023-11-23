package step4.racing;

import step4.racing.inout.OutPutView;

import java.util.List;

public class Winners {

    List<Car> winners;

    private Winners(List<Car> winners) {
        this.winners = winners;
    }

    public static Winners defaultOf(List<Car> winners) {
        return new Winners(winners);
    }

    public void printWinners(OutPutView outPutView) {
        int size = winners.size();
        for (int i = 0; i < size; i++) {
            winners.get(i).printName(outPutView);
            outPutView.printCommas(size-1 != i);
        }
        outPutView.printWinnerMessage();
    }

    public boolean contains(Car car) {
        for (Car winner : this.winners) {
            if (winner.equals(car)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Winners{" +
                "winners=" + winners +
                '}';
    }
}
