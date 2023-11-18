package racingcar.view.dto;

public class RacingGameInput {

        private String carNamesInOneText;
        private int round;

        public RacingGameInput(String carNamesInOneText, int round) {
                this.carNamesInOneText = carNamesInOneText;
                this.round = round;
        }

        public String getCarNamesInOneText() {
                return carNamesInOneText;
        }

        public int getRound() {
                return round;
        }
}
