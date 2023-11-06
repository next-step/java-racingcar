package car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {
    private int position;
    private String mark = "";

    public Car() {
        this.position = 0;
    }

    public void move(int randomNumber) {
        if(randomNumber >= 4) {
            this.position++;
            this.mark += "-";
        }
    }

    public int currentPosition() {
        return this.position;
    }

    public String moveMark() {
        return this.mark;
    }

}
