package racingcar.racing.model;

public class Car implements Movable {

    private final int id;

    private final String participantName;

    private int position;


    public Car(int id, String participantName) {
       this(id, participantName, 0);
    }


    public Car(int id, String participantName, int position) {

        this.id = id;
        this.participantName = participantName;
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public int getId() {
        return id;
    }

    public String getParticipantName() {
        return participantName;
    }

    @Override
    public void forward(boolean value) {
        if(value) {
            position++;
        }
    }

}
