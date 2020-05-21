package step5.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultRecorder {
    private final List<Record> result;

    public ResultRecorder() {
        this.result = new ArrayList<>();
    }

    public void recordCurrentPosition(List<Trace> traces){
        result.add(new Record(traces));
    }

    public List<String> findWinners(){
        resultCheck();
        List<Trace> last = result.get(result.size() - 1).getTraces();
        int maxPosition = findMaxPosition(last);

        return last.stream()
                .filter(trace -> trace.isSamePosition(maxPosition))
                .map(Trace::getName)
                .collect(Collectors.toList());
    }

    public List<Record> getResult() {
        return result;
    }

    private int findMaxPosition(List<Trace> last) {
        return last.stream()
                .mapToInt(Trace::getPosition)
                .max().getAsInt();
    }

    private void resultCheck() {
        if (result.isEmpty()) {
            throw new IllegalStateException("기록된 결과가 없습니다.");
        }
    }
}
