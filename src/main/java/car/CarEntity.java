package car;

public class CarEntity {

    String carName;
    int number = 0;

    String getCarName(){
        return carName;
    }
    int getNumber(){
        return number;
    }
    void setCarName(String carName){
        this.carName = carName;
    }
    void setNumber(int number){
        this.number = number;
    }
}
