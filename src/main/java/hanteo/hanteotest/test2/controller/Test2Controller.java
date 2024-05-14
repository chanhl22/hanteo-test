package hanteo.hanteotest.test2.controller;

import hanteo.hanteotest.test2.domain.Test2Service;
import hanteo.hanteotest.test2.view.InputData;
import hanteo.hanteotest.test2.view.OutputData;

import java.util.List;

public class Test2Controller {

    private final Test2Service test2Service;

    public Test2Controller(Test2Service test2Service) {
        this.test2Service = test2Service;
    }

    public void start() {
        int sum = readySum();
        List<Integer> coins = readyCoins();
        int result = test2Service.solution(sum, coins);
        OutputData.printResult(result);
    }

    private int readySum() {
        OutputData.printSumInputMessage();
        return InputData.getSum();
    }

    private List<Integer> readyCoins() {
        OutputData.printCoinsInputMessage();
        return InputData.getCoins();
    }

}
