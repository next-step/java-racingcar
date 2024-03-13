package racing.domain;

import racing.util.RandomNumberGenerator;
import racing.view.ResultView;


public class Car {
  private static final int RUNABLE_CONDITION = 4;
  private static final int MAX_NAME_LENGTH = 5;

  private static RandomNumberGenerator randomNumberGenerator;
  private String name;
  private int runCount=0;

  public Car(RandomNumberGenerator randomNumberGenerator, String name) {
    this.randomNumberGenerator = randomNumberGenerator;
    setName(name);
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
    StringBuilder statusBuilder = new StringBuilder();
    statusBuilder.append(name).append(" : ");
    System.out.print(statusBuilder);
    ResultView.raceProgress(this.runCount);
  }

  public void setName(String name) {
    if (name.length() > MAX_NAME_LENGTH) {
      throw new IllegalArgumentException("자동차의 이름은 5자를 초과할 수 없습니다.");
    }

    this.name = name;
  }

  public String getName() {
    return name;
  }
}
