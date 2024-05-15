package hanteo.hanteotest.test1.utils;

import java.util.List;

public class Validator {

    public void validateSearch(List<String> search) {
        checkLength(search);
    }

    private void checkLength(List<String> search) {
        if (search.size() != 2) {
            throw new IllegalStateException("[ERROR] 입력한 검색어를 다시 확인해주세요.");
        }
    }
}
