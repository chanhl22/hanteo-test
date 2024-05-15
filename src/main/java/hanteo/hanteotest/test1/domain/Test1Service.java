package hanteo.hanteotest.test1.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hanteo.hanteotest.test1.domain.dto.BoardDto;
import hanteo.hanteotest.test1.domain.dto.GenderDto;
import hanteo.hanteotest.test1.domain.dto.GroupDto;
import hanteo.hanteotest.test1.utils.DataGenerator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static hanteo.hanteotest.test1.domain.Gender.convertTextToGender;

public class Test1Service {

    private static final String GENDER = "성별";
    private static final String GROUP = "그룹";
    private static final String BOARD = "게시판";
    private final DataGenerator dataGenerator;

    public Test1Service(DataGenerator dataGenerator) {
        this.dataGenerator = dataGenerator;
    }

    public String find(String categoryIndex, String categoryName) {
        DataGenerator data = dataGenerator.init();
        List<Group> groups = data.getGroups();
        List<Board> boards = data.getBoards();

        if (isGender(categoryIndex)) {
            Map<Gender, List<Group>> genderMap = groups.stream()
                    .collect(Collectors.groupingBy(Group::getGender));

            Gender gender = convertTextToGender(categoryName);
            List<Group> searchGroups = genderMap.get(gender);
            return convertObjectToJsonString(GenderDto.of(gender, searchGroups));
        }

        if (isGroup(categoryIndex)) {
            GroupDto searchGroup = groups.stream()
                    .filter(group -> group.getGroupName().equals(categoryName))
                    .map(GroupDto::of)
                    .findFirst()
                    .orElseGet(GroupDto::empty);

            return convertObjectToJsonString(searchGroup);
        }

        if (isBoard(categoryIndex)) {
            List<BoardDto> searchBoards = boards.stream()
                    .filter(board -> board.getBoardName().equals(categoryName))
                    .map(BoardDto::of)
                    .collect(Collectors.toList());

            return convertObjectToJsonString(searchBoards);
        }

        throw new IllegalArgumentException("[ERROR] 입력한 검색어를 다시 확인해주세요.");
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

    private String convertObjectToJsonString(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        String result = null;
        try {
            result = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

}
