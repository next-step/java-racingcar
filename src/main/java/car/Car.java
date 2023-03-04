package car;

public class Car {
    private final CarName name;
    private int position = 0;

    public Car(String name, int position) {
        this.name = new CarName(name);
        this.position = position;
    }

    public Car(String name) {
        this.name = new CarName(name);
    }

    public void printPositionStatus() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        String currentPosition = sb.toString();
        System.out.println(this.name + " : " + currentPosition);
    }

    public void move(int randomValue) {
        if (randomValue >= 4) {
            this.position++;
        }
        printPositionStatus();
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return this.name.getName();
    }

    static class CarName {
        private final String name;

        public CarName(String name) {
            if (name.length() >= 5) throw new IllegalArgumentException("자동차 이름은 5자 미만만 가능 합니다. name = " + name);
            this.name = name;
        }
        
        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return this.getName();
        }
    }
}
