package step4;

public class Car {
    public String name;
    public int location = 0;

    public String setName(String name){
        this.name = name;
        return this.name;
    }

    public void moveForward(){
       this.location += 1;
    }
}
