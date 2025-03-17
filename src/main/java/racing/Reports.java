package racing;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Reports {

    private final List<Report> reports;

    public Reports(List<Car> cars) {
        this.reports = IntStream.range(0, cars.size())
                .boxed()
                .map(i -> new Report(i, cars.get(i).getPosition()))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Report> getReports() {
        return reports;
    }

    public void print(ScoreBoard scoreBoard) {
        reports.forEach(report -> scoreBoard.print(report.position));
    }

    public static class Report {

        private final int index;
        private final int position;

        public Report(int index, int position) {
            this.index = index;
            this.position = position;
        }

        public int getPosition() {
            return position;
        }
    }

    @FunctionalInterface
    public interface ScoreBoard {
        void print(int position);
    }
}
