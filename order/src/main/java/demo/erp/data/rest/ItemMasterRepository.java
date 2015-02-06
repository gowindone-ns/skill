package demo.erp.data.rest;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import demo.erp.data.model.ItemMaster;

@RepositoryRestResource(collectionResourceRel = "item", path = "item")
public interface ItemMasterRepository extends
		PagingAndSortingRepository<ItemMaster, String> {

	ItemMaster findByItemCode(@Param("itemCode") String itemCode);

	@Query("select itm from ItemMaster itm where itm.itemCategory LIKE :itemCategory%")
	List<ItemMaster> findByItemCategory(
			@Param("itemCategory") String itemCategory);
	
	@Query("select itm from ItemMaster itm where itm.itemName LIKE :itemName%")
	List<ItemMaster> findByItemName(
			@Param("itemName") String itemName);

}