package hanteo.hanteotest.test1.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum Gender {

    MAN("남자"),
    WOMAN("여자");

    private final String text;

    public static Gender convertTextToGender(String text) {
        return Arrays.stream(Gender.values())
                .filter(code -> code.getText().equals(text))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 입력한 검색어를 다시 확인해주세요."));
    }

}
