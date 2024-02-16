package test.com.mult.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO dao;

	public MemberServiceImpl() {
		log.info("MemberServiceImpl()....");
	}

	@Override
	public int insert(MemberVO vo) {

		return dao.insert(vo);
	}

	@Override
	public int update(MemberVO vo) {

		return dao.update(vo);
	}

	@Override
	public int delete(MemberVO vo) {

		return dao.delete(vo);
	}

	@Override
	public MemberVO selectOne(MemberVO vo) {

		return dao.selectOne(vo);
	}

	@Override
	public MemberVO login(MemberVO vo) {

		return dao.login(vo);
	}

	@Override
	public List<MemberVO> selectAll() {

		return dao.selectAll();
	}

	@Override
	public List<MemberVO> selectAll(int cpage, int pageBlock) {

		return dao.selectAll(cpage, pageBlock);
	}

	@Override
	public List<MemberVO> searchList(String searchKey, String searchWord) {

		return dao.searchList(searchKey, searchWord);
	}

	@Override
	public List<MemberVO> searchList(String searchKey, String searchWord, int cpage, int pageBlock) {

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
