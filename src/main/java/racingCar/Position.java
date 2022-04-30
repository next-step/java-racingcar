package racingCar;

public class Position {
    public static final int INITIAL_VALUE = 1;

    private int position;

    public Position(){
        this.position = INITIAL_VALUE;
    }

    public Position(int position) {
        this.position = position;
    }

    public String makePosition(){
        String temporaryString = "";
        for(int i=0; i<this.position;i++){
            temporaryString+="-";
        }
        return temporaryString;
    }

    public int getPosition() {
        return position;
    }

    public void increase(){
        this.position++;
    }

    public boolean checkPosition(int position){
        return this.position == position;
    }

    public boolean comparePosition(int comparePosition){
        if(comparePosition>this.position){
            return true;
        }
        return false;
    }

}
