package core;

class MoveAction implements CarAction {
    @Override
    public String carAction() {
        return "-";
    }
}

class StopAction implements CarAction {
    @Override
    public String carAction() {
        return "";
    }
}
