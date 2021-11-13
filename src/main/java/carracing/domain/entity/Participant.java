package carracing.domain.entity;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Participant {

  private static final String comma = ",";

  private final List<String> participant;

  public Participant(List<String> participant) {
    this.participant = participant;
  }

  public static Participant of(String names) {
    return new Participant(Arrays.stream(names.split(comma))
                                 .collect(toList()));
  }

  public List<String> getParticipant() {
    return participant;
  }
}
