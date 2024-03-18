package racingcar.step4.view.dto;

import racingcar.step4.domain.RacingCarGame;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGameDto {

  private final int round;
  private final List<CarDto> carDtos;

  private RacingCarGameDto(int round, List<CarDto> carDtos) {
    this.round = round;
    this.carDtos = carDtos;
  }

  public static RacingCarGameDto covert(RacingCarGame racingCarGame) {
    int round = racingCarGame.getRound();
    List<CarDto> carDtos = racingCarGame.getCars().stream()
        .map(it -> new CarDto(it.getCarName().get(), it.getPosition().get()))
        .collect(Collectors.toList());

    return new RacingCarGameDto(round, carDtos);
  }

  public int getRound() {
    return round;
  }

  public List<CarDto> getCarDtos() {
    return carDtos;
  }

  public static class CarDto {
    private final String carName;
    private final int position;

    public CarDto(String carName, int position) {
      this.carName = carName;
      this.position = position;
    }

    public String getCarName() {
      return carName;
    }

    public int getPosition() {
      return position;
    }
  }
}
