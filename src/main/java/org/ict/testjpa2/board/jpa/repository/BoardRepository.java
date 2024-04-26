package org.ict.testjpa2.board.jpa.repository;

import org.ict.testjpa2.board.jpa.entity.BoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//Mybatis 의 sqlSession 과 같은 역할을 수행함, 마이바티스 Mapper 인터페이스와 같음
//jpa 의 Repository 는 jpaRepository 를 상속 받아서 만듦
//제네릭스는 <엔티티클래스명, @id프로퍼티의 클래스자료형> 표기함
@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
    //JPQL을 이용한 Repository

    //@Query + Native Query사용(테이블명과 컬럼명 사용)
    @Query(value = "select board_num, board_title, board_readcount form board order by board_readcount desc", nativeQuery = true)
    List<BoardEntity> findTop3();
   //nativeQuery 사용시 컬럼명과 같은 get 메소드로만 구성된 nativeVo 인터페이스가 필요함

    //@Query + JPQL 사용 (엔티티와 프로퍼티 사용)
    @Query(value = "SELECT b FROM BoardEntity b WHERE b.boardTitle LIKE%:keyword%", countQuery = "SELECT COUNT(b) FROM BoardEntity b WHERE b.boardTitle LIKE%:keyword%")
    Page<BoardEntity> findSearch(@Param("keyword")String keyword, @Param("pageable") Pageable pageable);

    @Query(value = "SELECT b FROM BoardEntity b WHERE b.boardWriter LIKE%:keyword%", countQuery = "SELECT COUNT(b) FROM BoardEntity b WHERE b.boardWriter LIKE%:keyword%")
    Page<BoardEntity> findSearchWriter(@Param("keyword")String keyword, @Param("pageable") Pageable pageable);

    @Query(value = "SELECT b FROM BoardEntity b WHERE b.boardDate between :begin AND:end", countQuery = "SELECT COUNT(b) FROM BoardEntity b WHERE b.boardDate between :begin AND:end")
    Page<BoardEntity> findSearchDate(@Param("begin") java.sql.Date begin, @Param("pageable") Pageable pageable);

    //@Query + Native Query사용(테이블명과 컬럼명 사용)

    @Query(value="select count(*) from board where b.baord_title like %:keyword%", nativeQuery = true)
    Long countSearchTitle(@Param("keyword")String keyword);

    @Query(value="select count(*) from board where b.baord_writer like %:keyword%", nativeQuery = true)
    Long countSearchWriter(@Param("keyword")String keyword);

    @Query(value="select count(*) from board where b.baord_date between :begin and:end", nativeQuery = true)
    Long countSearchDate(@Param("begin") java.sql.Date begin, @Param("end") java.sql.Date end);

    @Query(value = "select max(board_num)from board", nativeQuery = true)
    int findLastBoardNum();

}