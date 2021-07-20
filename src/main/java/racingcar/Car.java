package racingcar;

public class Car {
    int position;

    public Car() {
        this.position = 1;
        print();
    }

    public void move(int randomNumber) {
        if(isMove(randomNumber)){
            this.position++;
        }
        print();
    }

    private void print(){
        for(int i=0; i<position; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public int getPosition() {
        return position;
    }

    public boolean isMove(int randomNumber) {
        final int MOVE_NUM = 4;
        if(randomNumber>=MOVE_NUM){
            return true;
        }
        return false;
    }
}
