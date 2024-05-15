package hanteo.hanteotest.test1.domain.dto;

import hanteo.hanteotest.test1.domain.Group;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class GroupDto {

    private final String groupName;

    private final List<BoardDto> boards;

    @Builder
    private GroupDto(String groupName, List<BoardDto> boards) {
        this.groupName = groupName;
        this.boards = boards;
    }

    public static GroupDto of(Group group) {
        return GroupDto.builder()
                .groupName(group.getGroupName())
                .boards(group.getGroupBoards().stream()
                        .filter(groupBoard -> groupBoard.getGroup().getParentIdx() == group.getParentIdx())
                        .map(groupBoard -> BoardDto.of(groupBoard.getBoard()))
                        .collect(Collectors.toList()))
                .build();

    }

}
