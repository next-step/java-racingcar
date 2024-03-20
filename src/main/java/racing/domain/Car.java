package racing.domain;

import racing.util.RandomNumberGenerator;

public class Car {

    private static final int RUNABLE_CONDITION = 4;
    private static final String PROGRESS_BAR = "-";

    private static RandomNumberGenerator randomNumberGenerator;
    private Name name;
    private int runCount = 0;

    public Car(RandomNumberGenerator randomNumberGenerator, String name) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.name = new Name(name);
    }

    public Name getName() {
        return name;
    }
    public int getRunCount() {
        return runCount;
    }

    private int getRandomNum() {
        return randomNumberGenerator.getRandomNumber(10);
    }

    private boolean runable(int num) {
        return num >= RUNABLE_CONDITION;
    }

    public void run() {
        if (runable(getRandomNum())) {
            runCount++;
        }
    }

    public void showStatus() {
        StringBuilder statusBuilder = new StringBuilder();
        statusBuilder.append(name).append(" : ");

        for (int i = 0; i < runCount; i++) {
            statusBuilder.append(PROGRESS_BAR);
        }

        System.out.println(statusBuilder);
    }
}
