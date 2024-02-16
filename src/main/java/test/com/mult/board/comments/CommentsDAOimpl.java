package test.com.mult.board.comments;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class CommentsDAOimpl implements CommentsDAO {

	@Autowired
	private SqlSession sqlSession;

	public CommentsDAOimpl() {
		log.info("CommentsDAOimpl()....");
	}

	@Override
	public int insert(CommentsVO vo) {
		log.info("comments insert()....");
		log.info(vo.toString());

		return sqlSession.insert("C_INSERT", vo);
	}

	@Override
	public int update(CommentsVO vo) {
		log.info("comments update()....");
		log.info(vo.toString());

		return sqlSession.update("C_UPDATE", vo);
	}

	@Override
	public int delete(CommentsVO vo) {
		log.info("comments delete()....");
		log.info(vo.toString());

		return sqlSession.delete("C_DELETE", vo);
	}

	@Override
	public List<CommentsVO> selectAll(CommentsVO vo) {
		log.info("comments selectAll()....");
		log.info(vo.toString());

		return sqlSession.selectList("C_SELECT_ALL", vo);
	}

}
