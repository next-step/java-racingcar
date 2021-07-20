package racingcar;

public class Car {
    private String name;
    private int position;

    public Car(String inputStr, int position) {
        if(inputStr.length()>5){
            throw new RuntimeException();
        }
        this.name = inputStr;
        this.position = position;
        print();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }


    public void move() {
        this.position++;
        print();
    }

    private void print(){
        System.out.print(name + " : ");
        for(int i=0; i<position; i++){
            System.out.print("-");
        }
        System.out.println();
    }
}
