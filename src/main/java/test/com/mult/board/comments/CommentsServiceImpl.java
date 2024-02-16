package test.com.mult.board.comments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentsServiceImpl implements CommentsService {

	@Autowired
	private CommentsDAO dao;

	@Override
	public int insert(CommentsVO vo) {

		return dao.insert(vo);
	}

	@Override
	public int update(CommentsVO vo) {

		return dao.update(vo);
	}

	@Override
	public int delete(CommentsVO vo) {

		return dao.delete(vo);
	}

	@Override
	public List<CommentsVO> selectAll(CommentsVO vo) {

		return dao.selectAll(vo);
	}

}
