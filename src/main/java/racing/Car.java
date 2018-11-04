package racing;

public class Car {
    int position;
    String name;

    Car (String name, int position){
        this.name = name;
        this.position = position;
    }

    public String getName(){
        return name;
    }
    public int getPosition(){
        return position;
    }
    public void addPosition(){
        this.position++;
    }


}
