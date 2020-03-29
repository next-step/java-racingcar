package RcingCarV2.view;

import RcingCarV2.model.Car;
import RcingCarV2.model.StageResult;

import java.util.List;

public class StageView {

    private List<StageResult> stageResults;

    public StageView(List<StageResult> stageResults) {
        this.stageResults = stageResults;
    }

    void print() {

        for (StageResult stageResult : stageResults) {
            List<Car> cars = stageResult.getCars();
            printStageResult(cars);
        }
    }

    void printStageResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            System.out.println(getMoveString(car.getPosition()));
        }
        System.out.println();
    }

    String getMoveString(int count) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append('-');
        }
        return stringBuilder.toString();
    }
}
