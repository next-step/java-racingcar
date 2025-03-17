package racing;

public class Car {

  int position;

  public int getPosition() {
    return position;
  }

  public void driveOrStop(int randomNumber) {
    if(randomNumber >= 4){
      position++;
    }
  }


}
