package racingcar;


public class Car extends Movable {

    public final String name;

    public Car(Environment environment, String name) {
        super(environment);
        this.name = name;
    }
}
