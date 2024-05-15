package hanteo.hanteotest.test1.controller;

import hanteo.hanteotest.test1.domain.Test1Service;
import hanteo.hanteotest.test1.view.InputData;
import hanteo.hanteotest.test1.view.OutputData;

import java.util.List;

public class Test1Controller {

    private final Test1Service test1Service;

    public Test1Controller(Test1Service test1Service) {
        this.test1Service = test1Service;
    }

    public void start() {
        List<String> search = readySearch();
        String result = test1Service.find(search.get(0), search.get(1));
        OutputData.printResult(result);
    }

    private List<String> readySearch() {
        OutputData.printSearchInputMessage();
        return InputData.getSearch();
    }

}
