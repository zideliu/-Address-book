package entity;

public class Area {
	
	private int id;
	private String code;
	private String name;
	
	public Area() {
		super();
	}

	public Area(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	public Area(int id, String code, String name) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Area [id=" + id + ", code=" + code + ", name=" + name + "]";
	}
	
}
