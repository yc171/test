package entity;

import com.sun.xml.internal.txw2.annotation.XmlElement;

@XmlElement
public class stu {

	private Integer id;
	private String name;

	@XmlElement
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
