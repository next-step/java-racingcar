package racing;

public class Racing {
    private static final int PARTICIPANT = 2;

    private Racing() {
        throw new AssertionError();
    }

    static Cars startRacing(String inputNames, int moveCount) {
        if (invalidInputData(inputNames, moveCount)) {
            throw new IllegalArgumentException("자동차는 빈 값, 움직이는 횟수는 0 이하일 수 없습니다.");
        }

        String[] names = inputNames.split("\\s*,\\s*");
        if (invalidParticipantsCount(names.length)) {
            throw new IllegalArgumentException("참가하는 자동차는 두 대 이상이어야 합니다.");
        }

        return Cars.initCars(names);
    }

    private static boolean invalidInputData(String inputNames, int moveCount) {
        return inputNames == null || inputNames.isBlank() || moveCount < 1;
    }

    private static boolean invalidParticipantsCount(int participantCounts) {
        return participantCounts < PARTICIPANT;
    }

    public static Cars racing(Cars cars) {
        cars.moveCars();
        return cars;
    }
}
