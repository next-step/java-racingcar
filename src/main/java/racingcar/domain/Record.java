package racingcar.domain;

public class Record {

        private int position;
        private String name;

        public Record(int position, Name name) {
            this.position = position;
            this.name = name.getName();
        }

        public int getDistance() {
            return position;
        }

        public String getName() {
            return name;
        }
}
