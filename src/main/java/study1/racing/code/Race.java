package study1.racing.code;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Race {
  private final int START_NUM = 0;

  private final RaceRound raceRound;
  
  private final int round;

  public Race(int participant, int round) {
    this.raceRound = new RaceRound(Stream.generate(Car::new).limit(participant).collect(Collectors.toList()));
    this.round = round;
  }

  public List<RaceRound> start() {
    return IntStream
      .range(START_NUM, round)
      .boxed()
      .map((i) -> raceRound.move())
      .map((raceRound) -> roundCheck(raceRound))
      .collect(Collectors.toList());
  }

  public RaceRound roundCheck(RaceRound raceRound) {
    return new RaceRound(raceRound);
  }
}
