package hanteo.hanteotest.test1.domain.dto;

import hanteo.hanteotest.test1.domain.Gender;
import hanteo.hanteotest.test1.domain.Group;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class GenderDto {

    private final Gender gender;

    private final List<GroupDto> groups;

    @Builder
    private GenderDto(Gender gender, List<GroupDto> groups) {
        this.gender = gender;
        this.groups = groups;
    }

    public static GenderDto of(Gender gender, List<Group> groups) {
        return GenderDto.builder()
                .gender(gender)
                .groups(groups.stream()
                        .map(GroupDto::of)
                        .collect(Collectors.toList()))
                .build();
    }

}
