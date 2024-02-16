package test.com.mult.board.comments;

import java.util.List;

public interface CommentsService {

	public int insert(CommentsVO vo);

	public int update(CommentsVO vo);

	public int delete(CommentsVO vo);

	public List<CommentsVO> selectAll(CommentsVO vo);

}
