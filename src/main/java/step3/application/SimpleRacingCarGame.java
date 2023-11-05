package step3.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import step3.domain.Car;

public class SimpleRacingCarGame {

        private final static String RESET = "";
        private final static Random random = new Random();
        private final int carCnt;
        private final int round;
        private List<Car> cars = new ArrayList<>();
        private ArrayList<String> recordByRounds = new ArrayList<>();
        private String thisRoundRecord = RESET;

        public SimpleRacingCarGame(int carCnt, int round) {
                this.carCnt = carCnt;
                this.round = round;
        }

        public ArrayList<String> start() {
                return recordByRounds;
        }
}
