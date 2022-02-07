package model;

public class ChoiceDTO {

	private String type;
	private String image;
	private String explain;
	
	public ChoiceDTO(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public ChoiceDTO(String type, String image, String explain) {
		this.type = type;
		this.image = image;
		this.explain = explain;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	
	
	
	
}
