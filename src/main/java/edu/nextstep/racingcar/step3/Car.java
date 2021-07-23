package edu.nextstep.racingcar.step3;

public class Car {

    private Integer numberOfRandoms = 10;
    private Integer threshold = 4;

    private Randoms randomUtils;

    public Car(Integer numberOfRandoms, Integer threshold) {
        this.numberOfRandoms = numberOfRandoms;
        this.threshold = threshold;
        this.randomUtils = new RandomUtils();
    }

    public Car(Integer numberOfRandoms, Integer threshold, Randoms randomUtils) {
        this.numberOfRandoms = numberOfRandoms;
        this.threshold = threshold;
        this.randomUtils = randomUtils;
    }

    public boolean isMove() {
        Integer randomNumber = randomUtils.getRandomNumber(numberOfRandoms);
        System.out.println(String.format("randomNumber = %s", randomNumber));
        return randomNumber >= threshold;
    }
}
