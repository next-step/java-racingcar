package carRacing;

import java.util.List;

class ResultView {


    public void printRacingResult(List<Car> cars) {
        for (Car car : cars) {
            int movement = car.getMovement();
            String record = recordToString(movement);
            System.out.println(record);
        }
        System.out.println();
    }

    public String recordToString(int movement) {
        StringBuilder records = new StringBuilder();
        for (int i = 0; i < movement; i++) {
            records.append("-");
        }
        return records.toString();
    }
}
