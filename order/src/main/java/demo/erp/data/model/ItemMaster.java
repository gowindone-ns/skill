package demo.erp.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item_master")
public class ItemMaster {

	
	public String getItemCode() {
		return itemCode;
	}

	
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	@Column(name = "item_name")
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Column(name = "item_type")
	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	@Column(name = "item_category")
	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	@Id	
	@Column(name = "item_code")
	private String itemCode;
	private String itemName;
	private String itemType;
	private String itemCategory;

}
