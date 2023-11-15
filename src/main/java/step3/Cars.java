package step3;

import java.util.List;

public class Cars {
    List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public boolean isSize(int size) {
        return cars.size() == size;
    }

    public void start(Referee referee, int howManyTimes,OutPutView outPutView) {
        for (int i = 0 ; i < howManyTimes; i++) {
            this.judge(referee);
            this.result(outPutView);
        }
    }

    private void judge(Referee referee) {
        for (Car each : cars) {
            referee.judge(each);
        }
    }

    public void result(OutPutView outPutView) {
        outPutView.printGap();
        for (Car each : this.cars) {
            each.result(outPutView);
        }
    }
}
