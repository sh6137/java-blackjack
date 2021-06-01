package study;

public class Car {
    private final String name;
    int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public Car move(final MoveStrategy moveStrategy){
        if (moveStrategy.isMovable()){
            position = position +1;
        }
        return this;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
