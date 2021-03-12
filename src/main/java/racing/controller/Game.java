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

  private void init(){
    carFactory.makeAndReturnCar(carCount);
  }

  public void run(){


  }
}
