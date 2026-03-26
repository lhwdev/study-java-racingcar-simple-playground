package racingcar;


public class Car extends Movable {

    public record Name(String value) {
        public Name {
            if (value.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하여야 합니다");
            }
        }
    }


    public final Name name;

    public Car(Environment environment, Name name) {
        super(environment);
        this.name = name;
    }


    public String getName() {
        return name.value;
    }
}
