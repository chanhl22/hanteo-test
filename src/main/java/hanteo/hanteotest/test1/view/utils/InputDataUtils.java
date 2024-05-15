package hanteo.hanteotest.test1.view.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputDataUtils {

    private static final String COMMA = ",";

    public static List<String> splitWithComma(String search) {
        return Arrays.stream(search.split(COMMA))
                .collect(Collectors.toList());
    }
}
