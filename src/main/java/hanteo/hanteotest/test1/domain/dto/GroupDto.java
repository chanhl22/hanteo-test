package hanteo.hanteotest.test1.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import hanteo.hanteotest.test1.domain.Group;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class GroupDto {

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private final int id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String groupName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<BoardDto> boards;

    @Builder
    private GroupDto(int id, String groupName, List<BoardDto> boards) {
        this.id = id;
        this.groupName = groupName;
        this.boards = boards;
    }

    public static GroupDto of(Group group) {
        return GroupDto.builder()
                .id(group.getParentIdx())
                .groupName(group.getGroupName())
                .boards(group.getGroupBoards().stream()
                        .filter(groupBoard -> groupBoard.getGroup().getParentIdx() == group.getParentIdx())
                        .map(groupBoard -> BoardDto.of(groupBoard.getBoard()))
                        .collect(Collectors.toList()))
                .build();

    }

    public static GroupDto empty() {
        return GroupDto.builder().build();
    }

}
