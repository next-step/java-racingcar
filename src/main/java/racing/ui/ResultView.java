package racing.ui;

import racing.core.TrackInfo;

import java.util.List;

public class ResultView {

    private List<TrackInfo> trackInfos;
    private int numberOfCars;

    public ResultView(List<TrackInfo> trackInfos, int numberOfCars) {
        this.trackInfos = trackInfos;
        this.numberOfCars = numberOfCars;
    }

    public void printResult() {
        for (int i = 0; i < trackInfos.size(); i++) {
            System.out.println(trackInfos.get(i) + (i % numberOfCars == numberOfCars - 1? "\n" : ""));
        }
    }
}
