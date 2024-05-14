package hanteo.hanteotest.test2.view;

import hanteo.hanteotest.test2.view.utils.InputDataUtils;

import java.util.List;
import java.util.Scanner;

public class InputData {

    private static final Scanner sc = new Scanner(System.in);

    public static int getSum() {
        return sc.nextInt();
    }

    public static List<Integer> getCoins() {
        return InputDataUtils.splitWithComma(sc.next());
    }

}
