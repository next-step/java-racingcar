package step4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Result {
    private List<String> winner = new ArrayList<>();

    public void findWinner(Map<String, Integer> results) {
        Entry<String, Integer> max = findMaxValue(results);

        for (Entry<String, Integer> result : results.entrySet()) {
            setWinner(max, result);
        }
    }

    private void setWinner(Entry<String, Integer> max, Entry<String, Integer> result) {
        if(result.getValue() == max.getValue()) {
            this.winner.add(result.getKey());
        }
    }

    private Entry<String, Integer> findMaxValue(Map<String, Integer> results) {
        Entry<String, Integer> max = null;
        for (Entry<String, Integer> result : results.entrySet()) {
            max = setMax(max, result);
        }
        return max;
    }

    private Entry<String, Integer> setMax(Entry<String, Integer> max, Entry<String, Integer> result) {
        if(max == null || result.getValue() > max.getValue()) {
            max = result;
        }
        return max;
    }

    public List<String> getWinner() {
        return winner;
    }
}
