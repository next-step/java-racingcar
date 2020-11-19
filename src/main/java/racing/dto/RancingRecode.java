package racing.dto;

public class RancingRecode {
    private String name;
    private int position;

    public static RancingRecode of(String name, int position) {
        final RancingRecode recode = new RancingRecode();
        recode.setName(name);
        recode.setPosition(position);
        return recode;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
