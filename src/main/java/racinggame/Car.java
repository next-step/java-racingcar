package racinggame;

public class Car {
    String name;
    int location;

    public Car(String name, int location){
        this.location = location;
        this.name = name;
    }

    public void carMove(){
        this.location++;
    }

    public int getLocation(){
        return location;
    }

    public String getName(){
        return name;
    }
}
