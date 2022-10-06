package racingcarwinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingCarWinner {

    private static final int ADVANCE_MIN_VALUE = 4;
    private String participantName;
    private int carMovingCount;
    private String[] participantNames;
    private int participantNumber;
    private String printingStatus = "";
    private List<Car> carList = new ArrayList<>();

    public RacingCarWinner(String participantName, int carMovingCount) {
        this.participantName = participantName;
        this.carMovingCount = carMovingCount;
    }

    public void splitParticipantName() {
        participantNames = participantName.split(",");
        participantNumber = participantNames.length;
        for (int i = 0; i < participantNumber; i++) {
            carList.add(new Car(participantNames[i]));
        }
    }

    public int judgmentGoStop() {
        int randomNum = (int) (Math.random() * 10);
        if (randomNum >= ADVANCE_MIN_VALUE) {
            return 1;
        }
        return 0;
    }

    public List<Integer> racingCarMove() {
        List<Integer> carMovement = new ArrayList<>();
        for (int i = 0; i < participantNumber; i++) {
            carMovement.add(i, judgmentGoStop());
        }
        return carMovement;
    }

    public void updateParticipantInformation() {
        List<Integer> carMovement = racingCarMove();
        int eachNumberOfMove = 0;
        for (int i = 0; i < participantNumber; i++) {
            eachNumberOfMove = carList.get(i).getPosition() + carMovement.get(i);
            carList.get(i).setPosition(eachNumberOfMove);
        }
        printGameStatus();
    }

    public String printGameStatus() {
        for (int i = 0; i < participantNumber; i++) {
            printingStatus += participantNames[i] + " : " + printCarBar(i) + "\n";
        }
        printingStatus += "\n";
        return printingStatus;
    }

    public String printCarBar(int participantTurn) {
        int moveDistance = carList.get(participantTurn).getPosition();
        String distanceBar = "";
        for (int i = 0; i < moveDistance; i++) {
            distanceBar += "-";
        }
        return distanceBar;
    }

    public String winner() {
        int max = carList.get(0).getPosition();
        String winnerParticipant = carList.get(0).getCarName();
        for (int i = 1; i < participantNumber; i++) {
            if (max == carList.get(i).getPosition()) {
                winnerParticipant += "," + carList.get(i).getCarName();
            }
            if (max < carList.get(i).getPosition()) {
                max = carList.get(i).getPosition();
                winnerParticipant = carList.get(i).getCarName();
            }
        }
        return winnerParticipant + "가 최종우승했습니다.";
    }

    public String racingCarGame() {
        for (int i = 0; i < carMovingCount; i++) {
            updateParticipantInformation();
        }
        printingStatus += winner();
        return printingStatus;
    }

    public String startGame() {
        splitParticipantName();
        return racingCarGame();
    }

}
