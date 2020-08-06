package step3.model;

public class Car{
    int RandomValue;
    private int position =0;

    public Car(){

    }

    public Car(int randomValue) {
        RandomValue = randomValue;
    }

    public void move(int randomValue){
        if(randomValue >=4){
            position++;
        }
    }
    public int getPosition(){
        return position;
    }
}
