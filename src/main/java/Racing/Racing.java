package Racing;

import Racing.view.InputModel;
import Racing.view.InputView;
import Racing.view.ResultView;

public class Racing {

  public static void main(String[] args) {
    InputModel inputModel = new InputView().scanInput();
    ResultView resultView = new ResultView();

    Race race = new Race(inputModel.countOfCar, inputModel.countOfStage);
    race.run();

    String result = resultView.draw(race);
    System.out.println(result);
  }
}
