package racingcar.step3.domain;

import java.util.*;

/**
 * Created : 2020-11-09 오전 8:25.
 * Developer : Seo.
 */
public class Record {
    private final List<Map<String, Integer>> totalRecords;

    public Record() {
        this.totalRecords = new ArrayList<>();
    }

    public void setTotalRecords(Map<String, Integer> turnRecords) {
        totalRecords.add(turnRecords);
    }

    public List<Map<String, Integer>> getTotalRecords() {
        return this.totalRecords;
    }

    public int getBest() {
        Map<String, Integer> lastRecord = totalRecords.get(totalRecords.size()-1);
        Optional<Map.Entry<String, Integer>> entry = lastRecord.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue));

        int best = 0;
        if (entry.isPresent()) {
            best = entry.get().getValue();
        }
        return best;
    }

    public String getWinner() {
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> lastRecord = totalRecords.get(totalRecords.size()-1);
        for (Map.Entry<String, Integer> entry2 : lastRecord.entrySet()) {
            if (entry2.getValue() == getBest()) {
                sb.append(", ").append(entry2.getKey());
            }
        }
        return sb.toString().replaceFirst(", ", "");
    }

}
