package race.view;

import race.Cars;

import java.util.List;

import static java.lang.System.out;

public class ResultView {

    public void operate(Cars cars, int tryCount) {
        out.println("실행 결과");
        for(int i=0; i< tryCount; i++){
            print(cars.getDistanceByRound(i));
        }
    }

    private void print(List<Integer> distances) {
        for (Integer distance : distances) {
            out.println(distance);
        }
        out.println();
    }

    public ResultView() {

    }

}
