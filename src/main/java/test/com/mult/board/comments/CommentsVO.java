package test.com.mult.board.comments;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import lombok.Data;

@Data
public class CommentsVO implements Serializable {

	private int num;
	private String content;
	private String writer;
	private Timestamp wdate;
	private int bnum;

}
