package carracing.domain.entity;

import java.util.List;

public class Participant {

  private final List<Name> participant;

  public Participant(List<Name> participant) {
    this.participant = participant;
  }

  public List<Name> getParticipant() {
    return participant;
  }

  public int size() {
    return participant.size();
  }

}
