package racing.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Grid {

    private List<Car> statingGrid;
    private final LinkedList<String> raceRecording;
    private static int round = 1;

    public Grid(LinkedList<String> raceRecording) {
        if(raceRecording == null) {
            raceRecording = new LinkedList<>();
        }
        this.raceRecording = raceRecording;
    }

    public Grid lineUp(int numberOfCars) {
        round = 1;
        this.statingGrid = IntStream.range(0,numberOfCars)
                        .mapToObj(pitOut -> new Car())
                        .collect(Collectors.toList());
        return this;
    }

    public Grid standingStart(int rounds) {
        while(round <= rounds) {
            statingGrid = statingGrid.stream()
                    .peek(Car::move)
                    .peek(Car -> raceRecording.add(Car.skidMark()))
                    .collect(Collectors.toList());
            round++;
            raceRecording.add("\n");
        }
        return this;
    }

    public List<Car> getStartingGrid() {
        return statingGrid;
    }
    public LinkedList<String> getRaceRecord() {
        return raceRecording;
    }

    public Grid finished() {
        return new Grid(raceRecording);
    }
}
