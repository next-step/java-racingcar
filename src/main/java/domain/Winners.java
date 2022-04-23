package domain;

import static util.Validator.validateArgument;

import java.util.List;
import java.util.StringJoiner;

public class Winners {

  private static final String WINNERS_DELIMITER = ", ";
  private static final String MESSAGE_FOR_INVALIDATE_WINNERS = "우승자가 올바르지 않습니다.";

  private final List<String> winners;

  Winners(List<String> winners) {
    validate(winners);
    this.winners = winners;
  }

  @Override
  public String toString() {
      StringJoiner stringJoiner = new StringJoiner(WINNERS_DELIMITER);
      winners.forEach(stringJoiner::add);
      return stringJoiner.toString();
  }

  public void validate(List<String> winners) {
    validateArgument(
        winners,
        (arg) -> arg != null && !arg.isEmpty(),
        MESSAGE_FOR_INVALIDATE_WINNERS
    );
  }
}
