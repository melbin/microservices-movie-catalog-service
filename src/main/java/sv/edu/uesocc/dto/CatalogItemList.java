package sv.edu.uesocc.dto;

import java.util.List;

public class CatalogItemList {
	
	private List<CatalogItem> catalogItemList;
	
	public CatalogItemList() {
		
	}
	
	public CatalogItemList(List<CatalogItem> catalogItemList) {
		super();
		this.catalogItemList = catalogItemList;
	}

	public List<CatalogItem> getCatalogItemList() {
		return catalogItemList;
	}

	public void setCatalogItemList(List<CatalogItem> catalogItemList) {
		this.catalogItemList = catalogItemList;
	}

}
