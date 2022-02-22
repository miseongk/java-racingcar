package racingcar.controller;

import racingcar.model.car.Cars;
import racingcar.model.trycount.TryCount;
import racingcar.util.RacingCarMovableStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    public RaceController() {
    }

    public void start() {
        Cars cars = getCars();
        TryCount tryCount = getTryCount();
        race(cars, tryCount);
        getWinners(cars);
    }

    public Cars getCars() {
        try {
            Cars cars = new Cars();
            cars.addAllFromNames(InputView.inputNames());
            return cars;
        } catch (IllegalArgumentException exception) {
            OutputView.printError(exception);
            return getCars();
        }
    }

    public TryCount getTryCount() {
        try {
            return new TryCount(InputView.inputTryCount());
        } catch (IllegalArgumentException exception) {
            OutputView.printError(exception);
            return getTryCount();
        }
    }

    public void race(Cars cars, TryCount tryCount) {
        OutputView.printRaceResult();
        for (int i = 0; i < tryCount.value(); i++) {
            cars.race(new RacingCarMovableStrategy());
            OutputView.printCars(cars);
        }
    }

    public void getWinners(Cars cars) {
        OutputView.printWinners(cars.getWinnersNames());
    }

}