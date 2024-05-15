package hanteo.hanteotest.test1.utils;

import hanteo.hanteotest.test1.domain.Board;
import hanteo.hanteotest.test1.domain.Group;

import java.util.List;

public interface InputDataGenerator {

    InputDataGenerator init();

    List<Group> getGroups();

    List<Board> getBoards();

}
