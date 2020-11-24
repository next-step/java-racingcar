package racingcarwinner;

public class Winner {

    private Name name;

    private Winner(){}

    public Winner(String name){
        this.name = new Name(name);
    }

    public Name getName(){
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Winner winner = (Winner) o;

        return name.equals(winner.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
