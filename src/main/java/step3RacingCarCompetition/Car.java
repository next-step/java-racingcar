package step3RacingCarCompetition;

public class Car {
    private String movingData = "";

    public void recordCarData(int totalMovingCount, RandomGenerator randomGenerator) {
        StringBuilder movingDataBuilder = new StringBuilder();
        for (int movingCount = 0; movingCount < totalMovingCount; movingCount++) {
            movingDataBuilder.append(randomGenerator.generateRandom());
        }
        movingData = movingDataBuilder.toString();
    }

    public String findEachMovingData(int movingCount) {
        return movingData.substring(0, movingCount);
    }

}
