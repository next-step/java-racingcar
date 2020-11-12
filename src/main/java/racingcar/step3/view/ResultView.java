package racingcar.step3.view;

import racingcar.step3.common.Consts;
import racingcar.step3.domain.Cars;
import racingcar.step3.domain.Record;

import java.util.Map;

/**
 * Created : 2020-11-02 오전 8:25.
 * Developer : Seo.
 */
public class ResultView {

    public void print(Cars cars, Record record) {
        Map<Integer, Map<String, Integer>> totalRecords = record.getTotalRecords();

        printTitle();
        for (int turn = 1; turn < totalRecords.size() + 1; turn++) {
            Map<String, Integer> turnRecords = totalRecords.get(turn);
            printDistance(turnRecords);
        }
        printWinner(cars);
    }

    private String gridDistance(Map<String, Integer> result) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            sb.append(entry.getKey()).append(" : ");
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append("-");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private void printTitle() {
        System.out.println(Consts.RESULT);
    }

    private void printDistance(Map<String, Integer> result) {
        System.out.println(gridDistance(result));
    }

    private void printWinner(Cars cars) {
        System.out.println(cars.getWinner() + Consts.HAVE_BEEN_A_WINNER);
    }

}
