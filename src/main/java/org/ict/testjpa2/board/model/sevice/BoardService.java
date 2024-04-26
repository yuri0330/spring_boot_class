package org.ict.testjpa2.board.model.sevice;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.testjpa2.board.jpa.entity.BoardEntity;
import org.ict.testjpa2.board.jpa.repository.BoardNativeVo;
import org.ict.testjpa2.board.jpa.repository.BoardRepository;
import org.ict.testjpa2.board.model.dto.BoardDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    //Servicr ㅇ대한 interface 를 만들어서 , 상속받은 ServiceImpl 클래스를 만드는 구조로 작성해도됨

    private final BoardRepository boardRepository;

    public ArrayList<BoardDto> selectTop3() {
        List<BoardEntity> entityList =boardRepository.findTop3();
        ArrayList<BoardDto>list = new ArrayList<>();
        // 내림차순 정렬된 상위3개만 추출함
        //JPQL 은where, group by 절에서만 서브쿼리 사용 가능함 =>from 절에서 서브쿼리 사용 못함
        for(int i = 0;i<3;i++){
            BoardEntity entity = entityList.get(i);
            BoardDto dto = entity.toDatoTop3();
            list.add(dto);
        }

        return list;
    }
}
