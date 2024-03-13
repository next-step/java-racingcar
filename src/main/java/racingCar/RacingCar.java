package racingCar;

public class RacingCar {
    private int position;
    private RacingCarName name;

    public RacingCar(){
        this.position = 0;
    }

    public RacingCar(String name){
        this.position = 0;
        this.name = new RacingCarName(name);
    }


    public int positionOfRacingCar(){
        return this.position;
    }

    public void move(MovingStrategy movingStrategy){
        if (movingStrategy.isMove()){
            this.position++;
        }
    }

    public String NameOfCar(){
        return this.name.whatIsCarName();
    }
}
