package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class RoundRecord {

    private List<Integer> positions;

    public RoundRecord() {
        this.positions = new ArrayList<>();
    }

    public void add(int position) {
        positions.add(position);
    }

    public String print(){
        StringBuilder result = new StringBuilder();
        for (Integer position : positions){
            result.append("_".repeat(Math.max(0, position)));
            result.append("\n");
        }
        return result.toString();
    }

    @Override
    public String toString() {
        return "RoundRecord{" +
                "positions=" + positions +
                '}';
    }
}
