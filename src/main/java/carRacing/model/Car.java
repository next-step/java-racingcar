package carRacing.model;


public class Car {
    private String carName;
    private int position;

    public Car(){
        this("noName");
    }

    public Car(String carName) {
        this.carName = carName;
        this.position = 0;
    }

    public void moveByRandomInt(int randomInt){
        if (randomInt >= 4)
            this.position += 1;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(String.format("%5s : ",carName));
        for (int i = 0; i < position; i++) {
            result.append("-");
        }
        return result.toString();
    }

    public int getPosition() {
        return position;
    }
}
