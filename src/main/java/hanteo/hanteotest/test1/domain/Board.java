package hanteo.hanteotest.test1.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class Board {

    private final int childId;
    private final String boardName;
    private List<GroupBoard> GroupBoards;

    @Builder
    private Board(int childId, String boardName) {
        this.childId = childId;
        this.boardName = boardName;
    }

    public static Board create(int childId, String boardName) {
        return Board.builder()
                .childId(childId)
                .boardName(boardName)
                .build();
    }

    public void updateGroupBoards(List<GroupBoard> groupBoards) {
        GroupBoards = groupBoards;
    }

}
