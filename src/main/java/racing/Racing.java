package racing;

public class Racing {
    private Car[] participants;
    private int round;

    public Racing(int cars, int round) {
        this.participants = new Car[cars];
        for (int i=0; i<cars; i++) {
            participants[i] = new Car();
        }
        this.round = round;
    }

    public Racing(String[] cars, int round) {
        this.participants = new Car[cars.length];
        for (int i=0; i<cars.length; i++) {
            Car car = new Car();
            car.setName(cars[i]);
            participants[i] = car;
        }
        this.round = round;
    }

    public void race() {
        for (int i=0; i<round; i++) {
            updateCar();
            ResultView.print("");
        }
    }

    private void updateCar() {
        for (Car participant : participants) {
            participant.move();
            participant.showDistance();
        }
    }

    public void winner() {
        int longest_distance = findLongestDistance();
        String winner = "";
        for (Car participant : participants) {
            winner += participant.getDistance() != longest_distance ?
                    "" :
                        winner.isEmpty() ?
                        participant.getName() : ", " + participant.getName();
        }
        ResultView.print(winner + "가 최종 우승했습니다.");
    }

    private int findLongestDistance() {
        int longest_distance = 0;
        for (Car participant : participants) {
            longest_distance = Math.max(longest_distance, participant.getDistance());
        }
        return longest_distance;
    }
}
