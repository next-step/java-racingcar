package racingcar.step3.view;

import racingcar.step3.common.Consts;
import racingcar.step3.domain.Record;

import java.util.Map;

/**
 * Created : 2020-11-02 오전 8:25.
 * Developer : Seo.
 */
public class ResultView {

    public void print(Record record) {
        title();
        grid(record);
        winner(record);
    }

    private void title() {
        System.out.println(Consts.RESULT);
    }

    private void grid(Record record) {
        record.getTotalRecords().forEach(t -> System.out.println(distance(t)));
    }

    private String distance(Map<String, Integer> turnRecords) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : turnRecords.entrySet()) {
            sb.append(entry.getKey()).append(" : ");
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append("-");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private void winner(Record record) {
        System.out.println(record.getWinner() + Consts.HAVE_BEEN_A_WINNER);
    }

}
