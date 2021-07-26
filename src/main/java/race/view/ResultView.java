package race.view;

import race.Cars;

import java.util.List;

import static java.lang.System.out;

public class ResultView {

    public void operate(Cars cars, int tryCount) {
        out.println("실행 결과");
        for(int i=0; i< tryCount; i++){
            print(cars.getDistanceByRound(i));
            out.println();
        }
    }

    private void print(List<Integer> distances) {
        distances.forEach(this::printDash);
    }

    private void printDash(int distance) {
        out.print("-");
        for(int i=0; i<distance;i++){
            out.print("-");
        }
        out.println();
    }

    public ResultView() {

    }

}
