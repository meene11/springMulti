package test.com.mult.board;

import java.util.List;

public interface BoardService {

	public int insert(BoardVO vo);

	public int update(BoardVO vo);

	public int delete(BoardVO vo);

	public BoardVO selectOne(BoardVO vo);

	public List<BoardVO> selectAll();
	public List<BoardVO> selectAll(int cpage,int pageBlock);

	public List<BoardVO> searchList(String searchKey, String searchWord);
	public List<BoardVO> searchList(String searchKey, String searchWord,int cpage,int pageBlock);

	public int getTotalRows();
	public int getSearchTotalRows(String searchKey, String searchWord);
	
	
	
}
