package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Racing {
    final int participantNumber;

    final int iterate;

    private final List<Participant> participants = new ArrayList<Participant>();

    public Racing(int participantNumber, int iterate) {
        this.participantNumber = participantNumber;
        this.iterate = iterate;
        this.createParticipants();
    }

    public void start() {
        for (int i = 0; i < iterate; i++) {
            this.runRound();
        }
    }

    private void createParticipants() {
        for (int i = 0; i < this.participantNumber; i++) {
            this.participants.add(new Participant());
        }
    }

    private void runRound() {
        this.participants.forEach(Participant::moveByRandomOnRound);
    }

    public List<List<Integer>> getParticipantsRecord() {
        return this.participants.stream().map(Participant::getRacingRecord).collect(Collectors.toList());
    }
}
