package racing.ui;

import racing.core.Snapshot;

import java.util.List;

public class ResultView {

    private List<Snapshot> snapshots;
    private int numberOfCars;

    public ResultView(List<Snapshot> snapshots, int numberOfCars) {
        this.snapshots = snapshots;
        this.numberOfCars = numberOfCars;
    }

    public void printResult() {
        for (int i = 0; i < snapshots.size(); i++) {
            System.out.println(snapshots.get(i) + (i % numberOfCars == numberOfCars - 1? "\n" : ""));
        }
    }
}
