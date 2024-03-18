package carRacing.model;

public class RacingCar {

    private int position;
    private RacingCarName name;

    public RacingCar() {
        this.position = 0;
    }

    public RacingCar(String name, int position){
        this.position = position;
        this.name = new RacingCarName(name);
    }

    public int position() {
        return this.position;
    }

    public void move(MoveStrategy moveStrategy) {
        if(moveStrategy.isMove()){
            this.position++;
        }
    }
    public String name(){
        return this.name.name();
    }
}
