package racingcar;

import type.MessageFactory;

import java.util.ArrayList;

class RacingGameCore {
    private static final String INITIAL_POSITION_VALUE = "";

    private final RacingCars racingCars;

    private int stageCount;

    private RacingGameCore(final String[] carNames, final int stageCount) {
        ArrayList<Car> stringArrayList = new ArrayList<>();
        for(int i = 0; i < carNames.length; i++) {
            stringArrayList.add(Car.of(carNames[i], INITIAL_POSITION_VALUE));
        }
        this.racingCars = RacingCars.from(stringArrayList);
        this.stageCount = stageCount;
    }

    public static RacingGameCore of(final String[] carNames, final int stageCount) {
        return new RacingGameCore(carNames, stageCount);
    }

    private StringBuilder gameResultBuilder;

    public String run() {
        gameResultBuilder = new StringBuilder()
                .append("실행 결과\n");

        while(0 != stageCount--) {
            moveForwardWhenConditions();
            gameResultBuilder.append(MessageFactory.newLine());
        }

        return gameResultBuilder.append(racingCars.getWinner())
                                .append("가 최종 우승 했습니다.")
                                .toString().trim();
    }

    private void moveForwardWhenConditions() {
        for(int index = 0; index < racingCars.size(); index++) {
            racingCars.goForward(index, RandomNumberGenerator.generate());

            String name = racingCars.getNameByIndex(index);
            String position = racingCars.getPositonByIndex(index);

            gameResultBuilder.append(name).append(" : ").append(position).append(MessageFactory.newLine());
        }
    }
}
