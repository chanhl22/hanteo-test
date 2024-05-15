package hanteo.hanteotest.test1.domain.dto;

import hanteo.hanteotest.test1.domain.Gender;
import hanteo.hanteotest.test1.domain.Group;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class GenderSearchDto {

    private final Gender gender;

    private final List<GroupDto> groups;

    @Builder
    private GenderSearchDto(Gender gender, List<GroupDto> groups) {
        this.gender = gender;
        this.groups = groups;
    }

    public static GenderSearchDto of(Gender gender, List<Group> groups) {
        return GenderSearchDto.builder()
                .gender(gender)
                .groups(groups.stream()
                        .map(GroupDto::of)
                        .collect(Collectors.toList()))
                .build();
    }

}
