package hanteo.hanteotest.test1.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hanteo.hanteotest.test1.domain.dto.BoardDto;
import hanteo.hanteotest.test1.domain.dto.GenderSearchDto;
import hanteo.hanteotest.test1.domain.dto.GroupDto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static hanteo.hanteotest.test1.domain.Gender.MAN;
import static hanteo.hanteotest.test1.domain.Gender.WOMAN;
import static hanteo.hanteotest.test1.domain.Gender.convertTextToGender;

public class Test1Service {

    private static final String GENDER = "성별";
    private static final String GROUP = "그룹";
    private static final String BOARD = "게시판";
    private static List<Group> groups;
    private static List<Board> boards;

    public String find(String categoryIndex, String categoryName) {
        init();

        if (isGender(categoryIndex)) {
            Map<Gender, List<Group>> genderMap = groups.stream()
                    .collect(Collectors.groupingBy(Group::getGender));

            Gender gender = convertTextToGender(categoryName);
            List<Group> searchGroups = genderMap.get(gender);
            return convertObjectToJsonString(GenderSearchDto.of(gender, searchGroups));
        }

        if (isGroup(categoryIndex)) {
            List<GroupDto> searchGroups = groups.stream()
                    .filter(group -> group.getGroupName().equals(categoryName))
                    .map(GroupDto::of)
                    .collect(Collectors.toList());

            return convertObjectToJsonString(searchGroups);
        }

        if (isBoard(categoryIndex)) {
            List<BoardDto> searchBoards = boards.stream()
                    .filter(board -> board.getBoardName().equals(categoryName))
                    .map(BoardDto::of)
                    .collect(Collectors.toList());

            return convertObjectToJsonString(searchBoards);
        }

        return null;

    }

    private boolean isGender(String categoryIndex) {
        return GENDER.equals(categoryIndex);
    }

    private boolean isGroup(String categoryIndex) {
        return GROUP.equals(categoryIndex);
    }

    private boolean isBoard(String categoryIndex) {
        return BOARD.equals(categoryIndex);
    }

    public String convertObjectToJsonString(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        String result = null;
        try {
            result = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void init() {
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
    }

}
