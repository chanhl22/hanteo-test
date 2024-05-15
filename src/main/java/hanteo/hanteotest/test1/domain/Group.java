package hanteo.hanteotest.test1.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class Group {

    private final int parentIdx;
    private final String groupName;
    private final Gender gender;
    private List<GroupBoard> groupBoards;

    @Builder
    private Group(int parentIdx, String groupName, Gender gender) {
        this.parentIdx = parentIdx;
        this.groupName = groupName;
        this.gender = gender;
    }

    public static Group create(int parentIdx, String groupName, Gender gender) {
        return Group.builder()
                .parentIdx(parentIdx)
                .groupName(groupName)
                .gender(gender)
                .build();
    }

    public void updateGroupBoards(List<GroupBoard> groupBoards) {
        this.groupBoards = groupBoards;
    }

}