package racing.controller;

import racing.model.CarFactory;
import racing.view.ResultView;

public class Game {
  private final int carCount;
  private final int attempt;

  CarFactory carFactory;
  ResultView resultView;

  public Game(int carCount, int attempt){
    this.carCount = carCount;
    this.attempt = attempt;

    carFactory = new CarFactory();
    resultView = new ResultView();
  }

  public boolean run(){
    carFactory.init(carCount);

    for(int i=0; i<attempt; i++){
      carFactory.runCycle();
    }

    return true;
  }
}
