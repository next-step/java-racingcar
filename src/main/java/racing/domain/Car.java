package racing.domain;

import racing.util.RandomNumberGenerator;
import racing.view.ResultView;


public class Car {
  private static final int RUNABLE_CONDITION = 4;
  private static RandomNumberGenerator randomNumberGenerator;
  private int runCount=0;

  public Car(RandomNumberGenerator randomNumberGenerator) {
    this.randomNumberGenerator = randomNumberGenerator;
  }

  public void run(){
    if(runable(getRandomNum())){
      runCount++;
    }
  }

  public int getRunCount() {
    return runCount;
  }

  private int getRandomNum(){
    return randomNumberGenerator.getRandomNumber(10);
  }

  private boolean runable(int num){
    return num >= RUNABLE_CONDITION;
  }

  public void showStatus(){
    ResultView.raceProgress(this.runCount);
  }
}
