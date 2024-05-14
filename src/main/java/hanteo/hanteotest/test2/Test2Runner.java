package hanteo.hanteotest.test2;

import hanteo.hanteotest.test2.controller.Test2Controller;
import hanteo.hanteotest.test2.domain.Test2Service;

public class Test2Runner {

    public static void main(String[] args) {
        Test2Controller controller = new Test2Controller(new Test2Service());
        controller.start();
    }

}
