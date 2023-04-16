package car;

class Car {
    private final String name;
    private int position;
    private int number;

    public Car(int number) {
        this.name = "자동차" + number;
        this.position = 0;
        this.number = number;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void printStatus() {
        System.out.print(this.name + " : ");
        for (int i = 0; i < this.position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
