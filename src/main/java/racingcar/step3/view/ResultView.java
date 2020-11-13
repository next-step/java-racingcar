package racingcar.step3.view;

import racingcar.step3.common.Consts;
import racingcar.step3.domain.Record;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
        record.getTotalRecords().forEach(turnRecords -> System.out.println(distance(turnRecords)));
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
        int best = 0;
        List<Map<String, Integer>> totalRecords = record.getTotalRecords();
        Map<String, Integer> lastRecord = totalRecords.get(totalRecords.size()-1);

        Optional<Map.Entry<String, Integer>> entry = lastRecord.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue));

        if (entry.isPresent()) {
            best = entry.get().getValue();
        }

        String winner = "";
        for (Map.Entry<String, Integer> entry2 : lastRecord.entrySet()) {
            if (entry2.getValue() == best) {
                winner += ", " + entry2.getKey();
            }
        }

        System.out.println(winner.replaceFirst(", ", "") + Consts.HAVE_BEEN_A_WINNER);
    }

}
