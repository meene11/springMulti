package test.com.mult.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
public class BoardController {

	@Autowired
	private BoardService service;
	
	@Autowired
	private test.com.mult.board.comments.CommentsService comService;

	/**
	 * Simply selects the board view to render by returning its name.
	 */
	@RequestMapping(value = "/b_insert.do", method = RequestMethod.GET)
	public String b_insert() {
		log.info("Welcome b_insert...");

		return "board/insert";
	}

	@RequestMapping(value = "/b_insertOK.do", method = RequestMethod.POST)
	public String b_insertOK(BoardVO vo) {
		log.info("Welcome b_insertOK...");
		log.info("vo:{}", vo);

		int result = service.insert(vo);
		log.info("result:{}", result);

		if (result == 1) {
			return "redirect:b_selectAll.do";
		} else {
			return "redirect:b_insert.do";
		}

	}

	@RequestMapping(value = "/b_selectAll.do", method = RequestMethod.GET)
	public String b_selectAll(@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock, Model model) {
		log.info("Welcome b_selectAll...");

		log.info("cpage : {}, pageBlock : {}", cpage, pageBlock);

//		List<BoardVO> vos = service.selectAll();
		List<BoardVO> vos = service.selectAll(cpage, pageBlock);
		for (BoardVO x : vos) {
			log.info(x.toString());
		}
		log.info("================");

		model.addAttribute("vos", vos);

		int total_rows = service.getTotalRows();
		log.info("total_rows:" + total_rows);

		int totalPageCount = 1;
		if (total_rows / pageBlock == 0) {
			totalPageCount = 1;
		} else if (total_rows % pageBlock == 0) {
			totalPageCount = total_rows / pageBlock;
		} else {
			totalPageCount = total_rows / pageBlock + 1;
		}
		// 페이지 링크 몇개?
		model.addAttribute("totalPageCount", totalPageCount);

		return "board/selectAll";
	}

	@RequestMapping(value = "b_searchList.do", method = RequestMethod.GET)
	public String b_searchList(@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock, Model model, String searchKey, String searchWord) {
		log.info("Welcome b_searchList.do....");

		log.info("cpage : {}, pageBlock : {}", cpage, pageBlock);
		log.info("searchKey : {}, searchWord : {}", searchKey, searchWord);

//		List<BoardVO> vos = service.searchList(searchKey, searchWord);
		List<BoardVO> vos = service.searchList(searchKey, searchWord, cpage, pageBlock);
		for (BoardVO x : vos) {
			log.info(x.toString());
		}
		System.out.println("================");

		model.addAttribute("vos", vos);

		// 키워드검색 게시글수는 몇개?
		int total_rows = service.getSearchTotalRows(searchKey, searchWord);
		log.info("total_rows:" + total_rows);

		int totalPageCount = 1;
		if (total_rows / pageBlock == 0) {
			totalPageCount = 1;
		} else if (total_rows % pageBlock == 0) {
			totalPageCount = total_rows / pageBlock;
		} else {
			totalPageCount = total_rows / pageBlock + 1;
		}
		// 페이지 링크 몇개?
		model.addAttribute("totalPageCount", totalPageCount);

		return "board/selectAll";
	}

	@RequestMapping(value = "b_selectOne.do", method = RequestMethod.GET)
	public String b_selectOne(BoardVO vo, Model model) {
		log.info("Welcome b_selectOne....");
		log.info("vo:{}", vo);

		BoardVO vo2 = service.selectOne(vo);
		log.info("vo2:{}", vo2);

		model.addAttribute("vo2", vo2);
		
		//댓글목록 처리로직
		test.com.mult.board.comments.CommentsVO cvo = new test.com.mult.board.comments.CommentsVO();
		cvo.setBnum(vo.getNum());
		List<test.com.mult.board.comments.CommentsVO> cvos = comService.selectAll(cvo);
		
		model.addAttribute("cvos", cvos);

		return "board/selectOne";
	}

	@RequestMapping(value = "b_update.do", method = RequestMethod.GET)
	public String b_update(BoardVO vo, Model model) {
		log.info("Welcome b_update....");
		log.info("vo:{}", vo);

		BoardVO vo2 = service.selectOne(vo);
		log.info("vo2:{}", vo2);

		model.addAttribute("vo2", vo2);

		return "board/update";
	}

	@RequestMapping(value = "/b_updateOK.do", method = RequestMethod.POST)
	public String b_updateOK(BoardVO vo) {
		log.info("Welcome b_updateOK...");
		log.info("vo:{}", vo);

		int result = service.update(vo);
		log.info("result:{}", result);

		if (result == 1) {
			return "redirect:b_selectOne.do?num=" + vo.getNum();
		} else {
			return "redirect:b_update.do?num=" + vo.getNum();
		}

	}

	@RequestMapping(value = "b_delete.do", method = RequestMethod.GET)
	public String b_delete() {
		log.info("Welcome b_delete....");

		return "board/delete";
	}

	@RequestMapping(value = "/b_deleteOK.do", method = RequestMethod.POST)
	public String b_deleteOK(BoardVO vo) {
		log.info("Welcome b_deleteOK...");
		log.info("vo:{}", vo);

		int result = service.delete(vo);
		log.info("result:{}", result);

		if (result == 1) {
			return "redirect:b_selectAll.do";
		} else {
			return "redirect:b_delete.do?num=" + vo.getNum();
		}

	}

}
