package hanteo.hanteotest.test1.utils;

import java.util.List;

public class Validator {

    public void validateSearch(List<String> search) {
        checkLength(search);
        checkCategory(search);
        checkGender(search);
    }

    private void checkLength(List<String> search) {
        if (search.size() != 2) {
            throw new IllegalArgumentException("[ERROR] 입력한 검색어를 다시 확인해주세요.");
        }
    }

    private void checkCategory(List<String> search) {
        String categoryIndex = search.get(0);
        if (!("성별".equals(categoryIndex) || "그룹".equals(categoryIndex) || "게시판".equals(categoryIndex))) {
            throw new IllegalArgumentException("[ERROR] 입력한 카테고리를 다시 확인해주세요.");
        }
    }

    private void checkGender(List<String> search) {
        if (!"성별".equals(search.get(0))) {
            return;
        }

        if (!("남자".equals(search.get(1)) || "여자".equals(search.get(1)))) {
            throw new IllegalArgumentException("[ERROR] 성별은 남자 또는 여자만 입력해주세요.");
        }
    }

}
