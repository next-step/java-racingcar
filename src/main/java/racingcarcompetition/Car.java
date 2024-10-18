package racingcarcompetition;

public class Car {
    private String position = "";

    public void recordCarData(int totalMovingCount, RandomGenerator randomGenerator) {
        StringBuilder movingDataBuilder = new StringBuilder();
        for (int movingCount = 0; movingCount < totalMovingCount; movingCount++) {
            movingDataBuilder.append(randomGenerator.generateRandom());
        }
        position = movingDataBuilder.toString();
    }

    public String findEachMovingData(int movingCount) {
        return position.substring(0, movingCount);
    }

}
