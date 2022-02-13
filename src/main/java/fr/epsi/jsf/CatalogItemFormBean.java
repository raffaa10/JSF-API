package fr.epsi.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named
public class CatalogItemFormBean implements Serializable {
	
	private CatalogItem catalogItem = new CatalogItem();
	
	private List<CatalogItem> items = new ArrayList<>();

	
	public String addItem() {
		
		long itemId = this.items.size() + 1;
		this.items.add(new CatalogItem(itemId, this.catalogItem.getName(),
				this.catalogItem.getManufacturer(),
				this.catalogItem.getDescription(),
				this.catalogItem.getAvailableDate()
				));
		this.items.stream().forEach(item -> {
			System.out.println(item.toString());
		});
		return "list?faces-redirect=true";
	}

	public CatalogItem getCatalogItem() {
		return catalogItem;
	}

	public void setCatalogItem(CatalogItem catalogItem) {
		this.catalogItem = catalogItem;
	}

	public List<CatalogItem> getItems() {
		return items;
	}

	public void setItems(List<CatalogItem> items) {
		this.items = items;
	}
	
	

}