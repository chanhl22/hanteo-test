package hanteo.hanteotest.test1.domain.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class EmptyDto {

    private final String message;

    @Builder
    private EmptyDto(String message) {
        this.message = message;
    }

    public static EmptyDto of() {
        return EmptyDto.builder()
                .message("올바른 카테고리 식별자가 아닙니다.")
                .build();
    }

}
