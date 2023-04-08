public class CarPosition {

    private int position;

    public CarPosition(int position){
        if(position < 0){
            throw new IllegalArgumentException("차 움직임은 음수일 수 없습니다.");
        }
        this.position = position;
    }

    public CarPosition move(){
        return new CarPosition(this.position+1);
    }

    public int getPositionValue(){
        return position;
    }
}
