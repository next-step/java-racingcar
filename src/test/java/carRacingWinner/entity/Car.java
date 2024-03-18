package carRacingWinner.entity;

public class Car {

    String name;
    private final String display = "-";
    int location;

    public Car(String name) {
        if(name.length() > 5)
            throw new IllegalArgumentException("차량의 이름이 너무 깁니다.");
        this.name = name;
    }

    public void move() {
        location++;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void print() {
        System.out.print(name + " : ");
        for (int i = 0; i < location; i++) {
            System.out.print(display);
        }
    }
}
