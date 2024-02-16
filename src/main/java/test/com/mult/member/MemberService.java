package test.com.mult.member;

import java.util.List;

public interface MemberService {

	public int insert(MemberVO vo);

	public int update(MemberVO vo);

	public int delete(MemberVO vo);

	public MemberVO selectOne(MemberVO vo);

	public MemberVO login(MemberVO vo);

	public List<MemberVO> selectAll();

	public List<MemberVO> selectAll(int cpage, int pageBlock);

	public List<MemberVO> searchList(String searchKey, String searchWord);

	public List<MemberVO> searchList(String searchKey, String searchWord, int cpage, int pageBlock);

	public int getTotalRows();

	public int getSearchTotalRows(String searchKey, String searchWord);

}
