package sv.edu.uesocc.dto;

public class CatalogItem {
	
	private String name;
	private String desc;
	private int raiting;
	
	public CatalogItem() {
	}
	
	public CatalogItem(String name, String desc, int raiting) {
		super();
		this.name = name;
		this.desc = desc;
		this.raiting = raiting;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getRaiting() {
		return raiting;
	}
	public void setRaiting(int raiting) {
		this.raiting = raiting;
	}
	@Override
	public String toString() {
		return "CatalogItem [name=" + name + ", desc=" + desc + ", raiting=" + raiting + "]";
	}
	
}
