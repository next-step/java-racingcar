package racing;

public class Car {
    int moveCount;

    public Car () {
    }

    public void move () {
        int randomNumber = (int)(Math.random()*10);
        if (randomNumber >= 4) {
            moveCount++;
        }
    }

    public void printResult () {
        for (int i = 0; i < moveCount; i++) {
            System.out.print("-");
        }
    }

}
