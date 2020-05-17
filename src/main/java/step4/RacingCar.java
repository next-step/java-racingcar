package step4;

import step4.view.ConsoleInputView;
import step4.view.ConsoleResultView;
import step4.view.InputView;
import step4.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static step3.Utils.getRandomNumber;

/**
 * 기능 요구사항
 * - 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
 * - 자동차 이름은 쉼표(,)를 기준으로 구분한다.
 * - 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.
 * @link {https://edu.nextstep.camp/s/KDgLkV1d/ls/zH2V5r9p}
 */
public class RacingCar {
  private ResultView resultView;

  public void setGame (InputView inputView, ResultView resultView) {
    this.resultView = resultView;
    this.startRace(
      Arrays.stream(inputView.inputCars().split(","))
        .map(v -> Car.of(v))
        .collect(Collectors.toList()),
      inputView.inputTime()
    );
  }

  public void startRace (List<Car> cars, int time) {
    validateTime(time);
    System.out.println("\n실행 결과");
    for (int i = 0; i < time; i++) {
      cars.forEach(car -> car.going(moving(getRandomNumber())));
      this.resultView.print(cars);
    }
  }

  public static int moving (int randomNumber) {
    return randomNumber > 4 ? 1 : 0;
  }

  public static RacingCar of () {
    return new RacingCar();
  }

  public static void validateTime (int time) {
    if (time < 1) throw new IllegalArgumentException("시도 횟수는 1 이상만 가능합니다.");
  }

  public static void main(String[] args) {
    RacingCar.of().setGame(
      ConsoleInputView.of(),
      ConsoleResultView.of()
    );
  }
}
