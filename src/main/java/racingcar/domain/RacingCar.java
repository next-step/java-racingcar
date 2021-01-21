package racingcar.domain;

import java.util.Random;

public class RacingCar implements Car {
    private int position = 0;
    private String name;

    public RacingCar(String name) {
        this.name = name;
    }

    @Override
    public void go() {
        Random rand = new Random();
        int score = rand.nextInt(10);
        if(score >= 4){
            position++;
        }
    }

    @Override
    public void print() {
        StringBuilder stringBuilder = new StringBuilder(name + " : ");
        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }
        System.out.println(stringBuilder);
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public String getName() {
        return name;
    }
}