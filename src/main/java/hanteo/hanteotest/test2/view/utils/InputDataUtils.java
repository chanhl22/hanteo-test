package hanteo.hanteotest.test2.view.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputDataUtils {

    private static final String COMMA = ",";

    public static List<Integer> splitWithComma(String coins) {
        return Arrays.stream(coins.split(COMMA))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
