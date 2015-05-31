package basicClasses;

import java.io.Serializable;

import javax.swing.ImageIcon;

public class Party implements Serializable {
	private int id;
	private String name;
	private String letters;

	public Party(int code,String letters, String name) {
		this.id = code;
		this.name = name;
		this.letters=letters;
	}

	public String getLetters() {
		return letters;
	}

	public void setLetters(String letters) {
		this.letters = letters;
	}

	public int getCode() {
		return id;
	}

	public void setCode(int code) {
		this.id = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
