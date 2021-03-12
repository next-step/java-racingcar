package racing.model;

import racing.util.RandomGenerator;

public class Car{
  int location;
  private static final int MOVABLE_LENGTH = 4;

  public Car(){
    location = 0;
  }

  public int move(int randomValue) {
    if(randomValue>=MOVABLE_LENGTH){
      location+=1;
    }
    return location;
  }
}
