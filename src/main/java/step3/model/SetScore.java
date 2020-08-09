package step3.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SetScore {
    private List<Integer> setScore;

    public SetScore(int value) {
        this.setScore = Stream.iterate(0, i -> i)
                .limit(value)
                .collect(Collectors.toList());
    }

    public int getScoreOfCar(int numberOfParticipant) {
        return setScore.get(numberOfParticipant);
    }

    public void setScoreOfCar(int numberOfParticipant, int value) {
        setScore.set(numberOfParticipant, value);
    }

    public int getNumberOfParticipants() {
        return setScore.size();
    }
}
