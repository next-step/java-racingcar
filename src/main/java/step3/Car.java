package step3;

public class Car {
    private int id;
    private int position = 1;

    Car(int id){
        this.id = id;
    }

    public void move(int point){
        if(isMovable(point)){
            this.position++;
        }
    }

    private boolean isMovable(int point){
        return point >= 4;
    }

    // 테스트용
    public Integer getPosition(){
        return this.position;
    }
}
