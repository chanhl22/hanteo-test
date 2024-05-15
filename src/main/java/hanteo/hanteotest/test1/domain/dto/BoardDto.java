package hanteo.hanteotest.test1.domain.dto;

import hanteo.hanteotest.test1.domain.Board;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardDto {

    private final int id;
    private final String boardName;

    @Builder
    private BoardDto(int id, String boardName) {
        this.id = id;
        this.boardName = boardName;
    }

    public static BoardDto of(Board board) {
        return BoardDto.builder()
                .id(board.getChildId())
                .boardName(board.getBoardName())
                .build();
    }

}
