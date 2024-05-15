package hanteo.hanteotest.test1.controller;

import hanteo.hanteotest.test1.domain.Test1Service;
import hanteo.hanteotest.test1.utils.Validator;
import hanteo.hanteotest.test1.view.InputData;
import hanteo.hanteotest.test1.view.OutputData;

import java.util.List;

public class Test1Controller {

    private final Test1Service test1Service;
    private final Validator validator;

    public Test1Controller(Test1Service test1Service, Validator validator) {
        this.test1Service = test1Service;
        this.validator = validator;
    }

    public void start() {
        List<String> search = readySearch();

        validator.validateSearch(search);

        String result = test1Service.find(search.get(0), search.get(1));
        OutputData.printResult(result);
    }

    private List<String> readySearch() {
        OutputData.printSearchInputMessage();
        return InputData.getSearch();
    }

}
