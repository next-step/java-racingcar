package racingcarwinner;

import java.util.ArrayList;
import java.util.List;

public class RacingCarWinner {

    private static final int ADVANCE_MIN_VALUE = 4;
    private String participantName;
    private int carMovingCount;
    private List<Car> cars = new ArrayList<>();

    public RacingCarWinner(String participantName, int carMovingCount) {
        this.participantName = participantName;
        this.carMovingCount = carMovingCount;
    }

    public String startGame() {
        splitParticipantName();
        return racingCarGame();
    }

    private void splitParticipantName() {
        String[] participantNames = participantName.split(",");
        for (int i = 0; i < participantNames.length; i++) {
            cars.add(new Car(participantNames[i]));
        }
    }

    private String racingCarGame() {
        String printingStatus = "";
        for (int i = 0; i < carMovingCount; i++) {
            printingStatus += updateParticipantInformation();
        }
        printingStatus += determineWinner();
        return printingStatus;
    }

    private String updateParticipantInformation() {
        List<Integer> carMovement = moveRacingCar();
        int eachNumberOfMove = 0;
        for (int i = 0; i < cars.size(); i++) {
            eachNumberOfMove = cars.get(i).getPosition() + carMovement.get(i);
            cars.get(i).setPosition(eachNumberOfMove);
        }
        return printGameStatus();
    }

    private List<Integer> moveRacingCar() {
        List<Integer> carMovement = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            carMovement.add(i, judgeGoStop());
        }
        return carMovement;
    }

    private int judgeGoStop() {
        int randomNum = (int) (Math.random() * 10);
        if (randomNum >= ADVANCE_MIN_VALUE) {
            return 1;
        }
        return 0;
    }

    private String printGameStatus() {
        String printingStatus = "";
        for (int i = 0; i < cars.size(); i++) {
            printingStatus += cars.get(i).getCarName() + " : " + printCarBar(i) + "\n";
        }
        printingStatus += "\n";
        return printingStatus;
    }

    private String printCarBar(int participantTurn) {
        int moveDistance = cars.get(participantTurn).getPosition();
        String distanceBar = "";
        for (int i = 0; i < moveDistance; i++) {
            distanceBar += "-";
        }
        return distanceBar;
    }

    private String determineWinner() {
        int max = cars.get(0).getPosition();
        String winnerParticipant = "";
        for (Car carInformation : cars) {
            List<String> winnerResult = maxDistanceCar(carInformation, max, winnerParticipant);
            max = Integer.parseInt(winnerResult.get(0));
            winnerParticipant = winnerResult.get(1);
        }
        if (winnerParticipant.charAt(0) == ',') {
            return winnerParticipant.substring(1) + "가 최종우승했습니다.";
        }
        return winnerParticipant + "가 최종우승했습니다.";
    }

    private List<String> maxDistanceCar(Car carInformation, int max, String winnerParticipant) {
        List<String> maxDistanceResult = new ArrayList<>();
        int maxResult = max;
        String winnerParticipantResult = winnerParticipant;
        if (max == carInformation.getPosition()) {
            winnerParticipantResult += "," + carInformation.getCarName();
        }
        if (max < carInformation.getPosition()) {
            maxResult = carInformation.getPosition();
            winnerParticipantResult = carInformation.getCarName();
        }
        maxDistanceResult.add(String.valueOf(maxResult));
        maxDistanceResult.add(winnerParticipantResult);
        return maxDistanceResult;
    }

}
