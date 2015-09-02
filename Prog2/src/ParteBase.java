public class ParteBase {
	int total;
	int items;
	int base;
	int deleted;
	int modified;
	int added;
	
	public ParteBase(){
		total=0;
		items=0;
		base=0;
		deleted=0;
		modified=0;
		added=0;
	}
	public ParteBase(int total, int items, int base, int deleted, int modified, int added){
		this.total=total;
		this.items=items;
		this.base=base;
		this.deleted=deleted;
		this.modified=modified;
		this.added=added;
	}
	public void setTotal(int total){
		this.total+=total;
	}
	public int getTotal(){
		return total;
	}
	public void setItems(int items){
		this.items+=items;
	}
	public int getItems(){
		return items;
	}
	public void setBase(int base){
		this.base+=base;
	}
	public int getBase(){
		return base;
	}
	public void setDeleted(int deleted){
		this.deleted+=deleted;
	}
	public int getDeleted(){
		return deleted;
	}
	public void setModified(int modified){
		this.modified+=modified;
	}
	public int getModified(){
		return modified;
	}
	public void setAdded(int added){
		this.added+=added;
	}
	public int getAdded(){
		return added;
	}
	public void getNum(String file){
		
	}

}
