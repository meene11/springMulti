package test.com.mult.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class MemberDAOimpl implements MemberDAO {


	@Autowired
	private SqlSession sqlSession;

	public MemberDAOimpl() {
		log.info("MemberDAOimpl()....");
	}

	@Override
	public int insert(MemberVO vo) {
		log.info("insert()....");
		log.info(vo.toString());

		int flag = sqlSession.insert("INSERT", vo);

		log.info("flag : {}", flag);

		return flag;
	}

	@Override
	public int update(MemberVO vo) {
		log.info("update()....");
		log.info(vo.toString());

		int flag = sqlSession.update("UPDATE", vo);
		log.info("flag : {}", flag);

		return flag;
	}

	@Override
	public int delete(MemberVO vo) {
		log.info("delete()....");
		log.info(vo.toString());

		int flag = sqlSession.delete("DELETE", vo);
		log.info("flag : {}", flag);

		return flag;
	}

	@Override
	public MemberVO selectOne(MemberVO vo) {
		log.info("selectOne()....");
		log.info(vo.toString());

		MemberVO vo2 = sqlSession.selectOne("SELECT_ONE", vo);

		return vo2;
	}

	@Override
	public List<MemberVO> selectAll() {
		log.info("selectAll()....");

		List<MemberVO> vos = sqlSession.selectList("SELECT_ALL");

		return vos;
	}

	@Override
	public List<MemberVO> searchList(String searchKey, String searchWord) {
		log.info("searchList()....2");
		log.info(searchKey);
		log.info(searchWord);

		List<MemberVO> vos = null;

		if (searchKey.equals("id")) {
			vos = sqlSession.selectList("SEARCHLIST_ID", "%" + searchWord + "%");
		} else if (searchKey.equals("name")) {
			vos = sqlSession.selectList("SEARCHLIST_NAME", "%" + searchWord + "%");
		}

		return vos;
	}

	@Override
	public int getTotalRows() {
		log.info("getTotalRows()....");

		int total_rows = sqlSession.selectOne("TOTAL_ROWS");

		return total_rows;
	}

	@Override
	public List<MemberVO> selectAll(int cpage, int pageBlock) {
		log.info("selectAll()....");
		log.info("cpage:" + cpage);
		log.info("pageBlock:" + pageBlock);

		int startRow = (cpage - 1) * pageBlock + 1;
		int endRow = startRow + pageBlock - 1;
		log.info(startRow + "," + endRow);

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);

		List<MemberVO> vos = sqlSession.selectList("SELECT_ALL_PAGE_BLOCK", map);

		return vos;
	}

	@Override
	public int getSearchTotalRows(String searchKey, String searchWord) {
		log.info("getSearchTotalRows()....");
		log.info(searchKey);
		log.info(searchWord);

		int total_rows = 0;

		if (searchKey.equals("id")) {
			total_rows = sqlSession.selectOne("SEARCH_TOTAL_ROWS_ID", "%" + searchWord + "%");
		} else if (searchKey.equals("name")) {
			total_rows = sqlSession.selectOne("SEARCH_TOTAL_ROWS_NAME", "%" + searchWord + "%");
		}

		return total_rows;
	}

	@Override
	public List<MemberVO> searchList(String searchKey, String searchWord, int cpage, int pageBlock) {
		log.info("searchList()....4");
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

		List<MemberVO> vos = null;

		if (searchKey.equals("id")) {
			vos = sqlSession.selectList("SEARCHLIST_PAGE_BLOCK_ID", map);
		} else if (searchKey.equals("name")) {
			vos = sqlSession.selectList("SEARCHLIST_PAGE_BLOCK_NAME", map);
		}

		return vos;
	}

	@Override
	public MemberVO login(MemberVO vo) {
		log.info("login()....");
		log.info(vo.toString());

		MemberVO vo2 = sqlSession.selectOne("LOGIN", vo);

		return vo2;
	}

}
