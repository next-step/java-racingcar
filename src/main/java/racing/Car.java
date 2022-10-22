package racing;

public class Car {
    private int moveCount;

    public void move () {
        int randomNumber = (int)(Math.random()*10);
        if (randomNumber >= 4) {
            this.moveCount++;
        }
    }

    public int getMoveCount() {
        return this.moveCount;
    }

    public void printResult () {
        for (int i = 0; i < this.moveCount; i++) {
            System.out.print("-");
        }
    }

}
