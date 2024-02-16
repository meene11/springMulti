package test.com.mult.member;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class MemberVO implements Serializable {

	private int num;
	private String id;
	private String pw;
	private String name;
	private String tel;
	private String save_name;
	private MultipartFile file;
	

}
