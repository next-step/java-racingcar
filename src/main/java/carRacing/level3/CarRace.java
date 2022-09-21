package carRacing.level3;

import java.util.Random;

public class CarRace {
  public static int getRandomNum() {
    Random random = new Random();
    return random.nextInt(10);
  }

  public static Boolean canMove(int randomNum) {
    if(randomNum >= 4){
      return true;
    }return false;
  }

}
