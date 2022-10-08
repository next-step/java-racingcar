package racingcarwinner;

import java.util.ArrayList;
import java.util.List;

public class RacingCarWinner {

    private static final int ADVANCE_MIN_VALUE = 4;
    private String participantName;
    private int carMovingCount;
    private List<Car> carList = new ArrayList<>();

    public RacingCarWinner(String participantName, int carMovingCount) {
        this.participantName = participantName;
        this.carMovingCount = carMovingCount;
    }

    public void splitParticipantName() {
        String[] participantNames = participantName.split(",");
        for (int i = 0; i < participantNames.length; i++) {
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
        for (int i = 0; i < carList.size(); i++) {
            carMovement.add(i, judgmentGoStop());
        }
        return carMovement;
    }

    public String updateParticipantInformation() {
        List<Integer> carMovement = racingCarMove();
        int eachNumberOfMove = 0;
        for (int i = 0; i < carList.size(); i++) {
            eachNumberOfMove = carList.get(i).getPosition() + carMovement.get(i);
            carList.get(i).setPosition(eachNumberOfMove);
        }
        return printGameStatus();
    }

    public String printGameStatus() {
        String printingStatus = "";
        for (int i = 0; i < carList.size(); i++) {
            printingStatus += carList.get(i).getCarName() + " : " + printCarBar(i) + "\n";
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
        for (Car carInformation : carList) {
            if (max == carInformation.getPosition()) {
                winnerParticipant += "," + carInformation.getCarName();
            }
            if (max < carInformation.getPosition()) {
                max = carInformation.getPosition();
                winnerParticipant = carInformation.getCarName();
            }
        }
        return winnerParticipant + "가 최종우승했습니다.";
    }

    public String racingCarGame() {
        String printingStatus = "";
        for (int i = 0; i < carMovingCount; i++) {
            printingStatus += updateParticipantInformation();
        }
        printingStatus += winner();
        return printingStatus;
    }

    public String startGame() {
        splitParticipantName();
        return racingCarGame();
    }

}
