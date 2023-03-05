package carRacing;

public class Car {
    String name;
    int score;

    public Car(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public void addSore(int score) {
        this.score += score;
    }
}
