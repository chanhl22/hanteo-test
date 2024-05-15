package hanteo.hanteotest.test1.view;

import hanteo.hanteotest.test1.view.utils.InputDataUtils;

import java.util.List;
import java.util.Scanner;

public class InputData {

    private static final Scanner sc = new Scanner(System.in);

    public static List<String> getSearch() {
        return InputDataUtils.splitWithComma(sc.next());
    }

}
