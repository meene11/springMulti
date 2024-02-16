package test.com.mult.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class BoardDAOimpl implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;

	public BoardDAOimpl() {
		log.info("BoardDAOimpl()....");

	}

	@Override
	public int insert(BoardVO vo) {
		log.info("insert()....");
		log.info(vo.toString());

		return sqlSession.insert("B_INSERT", vo);
	}

	@Override
	public int update(BoardVO vo) {
		log.info("update()....");
		log.info(vo.toString());

		return sqlSession.update("B_UPDATE", vo);

	}

	@Override
	public int delete(BoardVO vo) {
		log.info("delete()....");
		log.info(vo.toString());

		return sqlSession.delete("B_DELETE", vo);
	}

	@Override
	public BoardVO selectOne(BoardVO vo) {
		log.info("selectOne()....");
		log.info(vo.toString());

		return sqlSession.selectOne("B_SELECT_ONE", vo);
	}

	@Override
	public List<BoardVO> selectAll() {
		log.info("selectAll()...");

		return sqlSession.selectList("B_SELECT_ALL");
	}

	@Override
	public List<BoardVO> searchList(String searchKey, String searchWord) {
		log.info("searchList()...");
		log.info(searchKey);
		log.info(searchWord);

		if (searchKey.equals("title")) {
			return sqlSession.selectList("B_SEARCHLIST_TITLE", "%" + searchWord + "%");
		} else if (searchKey.equals("content")) {
			return sqlSession.selectList("B_SEARCHLIST_CONTENT", "%" + searchWord + "%");
		} else {
			return null;
		}

	}

	@Override
	public int getTotalRows() {
		log.info("getTotalRows()....");

		return sqlSession.selectOne("B_TOTAL_ROWS");
	}

	@Override
	public List<BoardVO> selectAll(int cpage, int pageBlock) {
		log.info("selectAll()....");
		log.info("cpage:" + cpage);
		log.info("pageBlock:" + pageBlock);

		int startRow = (cpage - 1) * pageBlock + 1;
		int endRow = startRow + pageBlock - 1;
		log.info(startRow + "," + endRow);

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);

		return sqlSession.selectList("B_SELECT_ALL_PAGE_BLOCK", map);
	}

	@Override
	public List<BoardVO> searchList(String searchKey, String searchWord, int cpage, int pageBlock) {
		log.info("searchList()....");
		log.info(searchKey);
		log.info(searchWord);

		log.info("cpage:" + cpage);
		log.info("pageBlock:" + pageBlock);

		int startRow = (cpage - 1) * pageBlock + 1;
		int endRow = startRow + pageBlock - 1;
		log.info(startRow + "," + endRow);

		Map<String, String> map = new HashMap<String, String>();
		map.put("startRow", String.valueOf(startRow));
		map.put("endRow", String.valueOf(endRow));
		map.put("searchWord", "%" + searchWord + "%");

		if (searchKey.equals("title")) {
			return sqlSession.selectList("B_SEARCHLIST_PAGE_BLOCK_TITLE", map);
		} else if (searchKey.equals("content")) {
			return sqlSession.selectList("B_SEARCHLIST_PAGE_BLOCK_CONTENT", map);
		} else {
			return null;
		}
	}

	@Override
	public int getSearchTotalRows(String searchKey, String searchWord) {
		log.info("getSearchTotalRows()....");
		log.info(searchKey);
		log.info(searchWord);

		int total_rows = 0;

		if (searchKey.equals("title")) {
			total_rows = sqlSession.selectOne("B_SEARCH_TOTAL_ROWS_TITLE", "%" + searchWord + "%");
		} else if (searchKey.equals("content")) {
			total_rows = sqlSession.selectOne("B_SEARCH_TOTAL_ROWS_CONTENT", "%" + searchWord + "%");
		}

		return total_rows;
	}

}
