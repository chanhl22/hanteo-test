package hanteo.hanteotest.test1.utils;

import hanteo.hanteotest.test1.domain.Board;
import hanteo.hanteotest.test1.domain.Group;
import hanteo.hanteotest.test1.domain.GroupBoard;

import java.util.List;

import static hanteo.hanteotest.test1.domain.Gender.MAN;
import static hanteo.hanteotest.test1.domain.Gender.WOMAN;

public class DataGenerator implements InputDataGenerator {

    private List<Group> groups;
    private List<Board> boards;

    @Override
    public DataGenerator init() {
        Group exo = Group.create(1, "엑소", MAN);
        Group bts = Group.create(2, "방탄소년단", MAN);
        Group blackpink = Group.create(3, "블랙핑크", WOMAN);

        Board board1 = Board.create(1, "공지사항");
        Board board2 = Board.create(2, "첸");
        Board board3 = Board.create(3, "백현");
        Board board4 = Board.create(4, "시우민");
        Board board5 = Board.create(5, "공지사항");
        Board board6 = Board.create(6, "익명게시판");
        Board board7 = Board.create(7, "뷔");
        Board board8 = Board.create(8, "공지사항");
        Board board9 = Board.create(9, "로제");

        List<GroupBoard> groupBoards = List.of(
                GroupBoard.create(exo, board1),
                GroupBoard.create(exo, board2),
                GroupBoard.create(exo, board3),
                GroupBoard.create(exo, board4),
                GroupBoard.create(bts, board5),
                GroupBoard.create(bts, board6),
                GroupBoard.create(bts, board7),
                GroupBoard.create(blackpink, board8),
                GroupBoard.create(blackpink, board6),
                GroupBoard.create(blackpink, board9));

        exo.updateGroupBoards(groupBoards);
        bts.updateGroupBoards(groupBoards);
        blackpink.updateGroupBoards(groupBoards);

        board1.updateGroupBoards(groupBoards);
        board2.updateGroupBoards(groupBoards);
        board3.updateGroupBoards(groupBoards);
        board4.updateGroupBoards(groupBoards);
        board5.updateGroupBoards(groupBoards);
        board6.updateGroupBoards(groupBoards);
        board7.updateGroupBoards(groupBoards);
        board8.updateGroupBoards(groupBoards);
        board9.updateGroupBoards(groupBoards);

        groups = List.of(exo, bts, blackpink);
        boards = List.of(board1, board2, board3, board4, board5, board6, board7, board8, board9);
        return this;
    }

    @Override
    public List<Group> getGroups() {
        return groups;
    }

    @Override
    public List<Board> getBoards() {
        return boards;
    }

}
