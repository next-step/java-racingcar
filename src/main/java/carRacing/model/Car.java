package carRacing.model;

import carRacing.model.action.MovableImpl;

public class Car {

    private int position;

    public void decideMovable() {
        MovableImpl movableImple = new MovableImpl();
        if(movableImple.MoveOrNot()) {
            position++;
        }
    }

    public int getPoisition() {
        return position;
    }
}
