package fr.epsi.jsf;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@RequestScoped
public class CatalogItemDeleteBean {
	
	private long itemId;
	
	private CatalogItem catalogItem;
	
	@Inject
	private CatalogItemFormBean catalogItemFormBean;
	
	public void fetchItem() {
		
		List<CatalogItem> items = this.catalogItemFormBean.getItems().stream().filter(i -> {
			return i.getItemId() == itemId;
		}).collect(Collectors.toList());
		
		if (items.isEmpty()) {
			this.catalogItem = null;
		} else {
			this.catalogItem = items.get(0);
		}
	}
	
	public String removeItem() {
		
		this.catalogItemFormBean.getItems().removeIf(item -> {
			return item.getItemId().equals(this.itemId);
		});
		return "list?faces-redirect=true";
	}
	

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public CatalogItem getCatalogItem() {
		return catalogItem;
	}

	public void setCatalogItem(CatalogItem catalogItem) {
		this.catalogItem = catalogItem;
	}

	public CatalogItemFormBean getCatalogItemFormBean() {
		return catalogItemFormBean;
	}

	public void setCatalogItemFormBean(CatalogItemFormBean catalogItemFormBean) {
		this.catalogItemFormBean = catalogItemFormBean;
	}
	
	

}
