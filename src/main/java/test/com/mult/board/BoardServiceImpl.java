package test.com.mult.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO dao;
	
	public BoardServiceImpl() {
		log.info("BoardServiceImpl()...");
	}

	@Override
	public int insert(BoardVO vo) {

		return dao.insert(vo);
	}

	@Override
	public int update(BoardVO vo) {

		return dao.update(vo);
	}

	@Override
	public int delete(BoardVO vo) {

		return dao.delete(vo);
	}

	@Override
	public BoardVO selectOne(BoardVO vo) {

		return dao.selectOne(vo);
	}

	@Override
	public List<BoardVO> selectAll() {

		return dao.selectAll();
	}

	@Override
	public List<BoardVO> selectAll(int cpage, int pageBlock) {

		return dao.selectAll(cpage, pageBlock);
	}

	@Override
	public List<BoardVO> searchList(String searchKey, String searchWord) {

		return dao.searchList(searchKey, searchWord);
	}

	@Override
	public List<BoardVO> searchList(String searchKey, String searchWord, int cpage, int pageBlock) {

		return dao.searchList(searchKey, searchWord, cpage, pageBlock);
	}

	@Override
	public int getTotalRows() {

		return dao.getTotalRows();
	}

	@Override
	public int getSearchTotalRows(String searchKey, String searchWord) {

		return dao.getSearchTotalRows(searchKey, searchWord);
	}

}
