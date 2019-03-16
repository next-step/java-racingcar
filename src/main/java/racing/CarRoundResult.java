package racing;

public class CarRoundResult {
    private int roundNo;
    private int movePoint;
    private Car car;

    CarRoundResult(int roundNo,int movePoint,Car car){
        this.roundNo = roundNo;
        this.movePoint = movePoint;
        this.car = car;
    }

    public int getRoundNo(){
        return this.roundNo;
    }

    public int getMovePoint(){
        return this.movePoint;
    }

    public Car getCar(){
        return this.car;
    }
}
