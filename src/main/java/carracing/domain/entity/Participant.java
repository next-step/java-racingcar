package carracing.domain.entity;

import java.util.List;

public class Participant {

  private final List<Name> nameList;

  public Participant(List<Name> participant) {
    this.nameList = participant;
  }

  public List<Name> getParticipant() {
    return nameList;
  }

  public int size() {
    return nameList.size();
  }

}
