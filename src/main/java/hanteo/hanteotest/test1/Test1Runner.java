package hanteo.hanteotest.test1;

import hanteo.hanteotest.test1.controller.Test1Controller;
import hanteo.hanteotest.test1.domain.Test1Service;

public class Test1Runner {

    public static void main(String[] args) {
        Test1Controller controller = new Test1Controller(new Test1Service());
        controller.start();
    }

}
