package step3.dto;

public class Car {
    private int entryNumber;
    private int position;

    private Car(int entryNumber, int position) {
        this.entryNumber = entryNumber;
        this.position = position;
    }

    public static Car participateRacing(int entryNumber, int position){
        return new Car(entryNumber, position);
    }

    public void movePosition(){
        position++;
    }

    public int nowPosition(){
        return position;
    }

}
