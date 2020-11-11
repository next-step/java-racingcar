package racingcar.step3.view;

import racingcar.step3.common.Consts;
import racingcar.step3.domain.Car;
import racingcar.step3.domain.Record;

import java.util.List;
import java.util.Map;

/**
 * Created : 2020-11-02 오전 8:25.
 * Developer : Seo.
 */
public class ResultView {

    public void print(Record record) {
        Map<Integer, List<Car>> totalRecords = record.getTotalRecords();

        printTitle();
        for (int turn = 1; turn < totalRecords.size() + 1; turn++) {
            List<Car> turnRecords = totalRecords.get(turn);
            for (Car car : turnRecords) {
                printDistance(car);
            }
            printTurnOver();
        }
        printWinner(record);
    }

    private String gridDistance(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName()).append(" : ");
        for (int i = 0; i < car.getDistance(); i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    private void printTitle() {
        System.out.println(Consts.RESULT);
    }

    private void printDistance(Car car) {
        System.out.println(gridDistance(car));
    }

    private void printTurnOver() {
        System.out.println();
    }

    private void printWinner(Record record) {
        System.out.println(record.getWinner() + Consts.HAVE_BEEN_A_WINNER);
    }

}
