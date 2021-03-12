package racing.model;

public class RandomCar implements Car {
  int location;

  @Override
  public int move(boolean movable) {
    if(movable){
      location+=1;
    }
    return location;
  }
}
