package hanteo.hanteotest.test1.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class GroupBoard {

    private final Group group;
    private final Board board;

    @Builder
    private GroupBoard(Group group, Board board) {
        this.group = group;
        this.board = board;
    }

    public static GroupBoard create(Group group, Board board) {
        return GroupBoard.builder()
                .group(group)
                .board(board)
                .build();
    }

}
