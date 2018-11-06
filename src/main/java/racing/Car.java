package racing;


public class Car {
    private static final int MIN_NUM = 4;

    private int position;
    private String name;

    Car (String name){
        this.name = name;
    }

    Car (String name, int position){
        this.name = name;
        this.position = position;
    }

    private boolean isMove(int num) {
        return num >= MIN_NUM;
    }

    public String getName(){
        return name;
    }

    public int getPosition(){
        return position;
    }

    public Car addPosition(int num){
        if(isMove(num)) {
            this.position++;
        }
        return this;
    }

    public int getMaxPosition(int max) {
            return max < position ? position : max;
    }

    public String getWinner(int maxPosition) {
        if(maxPosition ==  position) {
            return name+ ",";
        }
        return "";
    }
}
