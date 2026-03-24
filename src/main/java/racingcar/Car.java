package racingcar;

import java.util.Random;


public class Car {
    public final String name;

    public int position = 0;
    private final Random obstacleAvoidance = new Random();


    public Car(String name) {
        this.name = name;
    }


    public void tryMove() {
        int speed = obstacleAvoidance.nextInt(0, 10);
        if(speed >= 4) {
            moveForward();
        }
    }

    private void moveForward() {
        position += 1;
    }
}
