package racingcar.domain;

public class Record {

        private int position;
        private String name;

        public Record(int position, CarName carName) {
            this.position = position;
            this.name = carName.getName();
        }

        public int getDistance() {
            return position;
        }

        public String getName() {
            return name;
        }
}
