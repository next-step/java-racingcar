package step3.domain;

public class Car {

        private static final String START_POINT = ".";
        private static final String PATH_SIGN = "-";
        private final String id;
        private String path;

        public Car(String id) {
                this.id = id;
                this.path = ".";
        }

        public void moveForward() {
                path = path.concat(PATH_SIGN);
        }

        public String getPath() {
                return path;
        }
}
