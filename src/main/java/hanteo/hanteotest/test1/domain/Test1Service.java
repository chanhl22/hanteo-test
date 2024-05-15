package hanteo.hanteotest.test1.domain;

import hanteo.hanteotest.test1.domain.dto.BoardDto;
import hanteo.hanteotest.test1.domain.dto.GenderDto;
import hanteo.hanteotest.test1.domain.dto.GroupDto;
import hanteo.hanteotest.test1.utils.InputDataGenerator;
import hanteo.hanteotest.test1.utils.JsonConverter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static hanteo.hanteotest.test1.domain.Gender.convertTextToGender;

public class Test1Service {

    private static final String GENDER = "성별";
    private static final String GROUP = "그룹";
    private static final String BOARD = "게시판";
    private final InputDataGenerator inputDataGenerator;

    public Test1Service(InputDataGenerator inputDataGenerator) {
        this.inputDataGenerator = inputDataGenerator;
    }

    public String find(String categoryIndex, String categoryName) {
        InputDataGenerator data = inputDataGenerator.init();
        List<Group> groups = data.getGroups();
        List<Board> boards = data.getBoards();

        if (isGender(categoryIndex)) {
            return makeGenderResponse(categoryName, groups);
        }

        if (isGroup(categoryIndex)) {
            return makeGroupResponse(categoryName, groups);
        }

        if (isBoard(categoryIndex)) {
            return makeBoardResponse(categoryName, boards);
        }

        throw new IllegalArgumentException("[ERROR] 입력한 검색어를 다시 확인해주세요.");
    }

    private boolean isGender(String categoryIndex) {
        return GENDER.equals(categoryIndex);
    }

    private String makeGenderResponse(String categoryName, List<Group> groups) {
        Map<Gender, List<Group>> genderMap = groups.stream()
                .collect(Collectors.groupingBy(Group::getGender));

        Gender gender = convertTextToGender(categoryName);
        List<Group> searchGroups = genderMap.get(gender);
        return JsonConverter.convertObjectToJsonString(GenderDto.of(gender, searchGroups));
    }

    private boolean isGroup(String categoryIndex) {
        return GROUP.equals(categoryIndex);
    }

    private String makeGroupResponse(String categoryName, List<Group> groups) {
        GroupDto searchGroup = groups.stream()
                .filter(group -> group.getGroupName().equals(categoryName))
                .map(GroupDto::of)
                .findFirst()
                .orElseGet(GroupDto::empty);

        return JsonConverter.convertObjectToJsonString(searchGroup);
    }

    private boolean isBoard(String categoryIndex) {
        return BOARD.equals(categoryIndex);
    }

    private String makeBoardResponse(String categoryName, List<Board> boards) {
        List<BoardDto> searchBoards = boards.stream()
                .filter(board -> board.getBoardName().equals(categoryName))
                .map(BoardDto::of)
                .collect(Collectors.toList());

        return JsonConverter.convertObjectToJsonString(searchBoards);
    }

}
