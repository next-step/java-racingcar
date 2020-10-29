package step3.domain;

public class Car {


    private int position;

    private Car (){
        position = 0;
    }

    public void move(){
        this.position ++;
    }

    public int getCarPosition(){
        return this.position;
    }


    public static Car of(){
        return new Car();
    }
}
