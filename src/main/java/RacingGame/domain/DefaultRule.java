package RacingGame.domain;

import RacingGame.RacingGame;
import RacingGame.domain.Car;
import RacingGame.domain.Rule;

import java.util.Random;

public class DefaultRule implements Rule {

    private static final int RANDOM_NUM_SCOPE = 10;
    private static final int FORWARD_NUM = 4;
    private static final Random RANDOM = new Random(); //반복사용하는 것은 한번만 선언


  public boolean move(){
      return isForward(getRandomValue());
  }

  private boolean isForward(int randomValue){
      return randomValue >= FORWARD_NUM;
  }

  protected int getRandomValue(){
      return RANDOM.nextInt(RANDOM_NUM_SCOPE);
  }


}
