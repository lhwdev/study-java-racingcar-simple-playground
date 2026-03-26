package racingcar.controller.console;

import racingcar.view.ProgressionView;


public class ProgressionController {

    public void printProgression(ProgressionView progression) {
        for (ProgressionView.CarProgression car : progression.cars) {
            printCar(car);
        }
    }

    private void printCar(ProgressionView.CarProgression progression) {
        System.out.print(progression.name);

        System.out.print(" : ");

        int position = progression.position;
        if (position >= 0) {
            String positionIndicator = "-".repeat(position);
            System.out.print(positionIndicator);
        } else {
            System.out.print("");
        }

        System.out.println();
    }

}
