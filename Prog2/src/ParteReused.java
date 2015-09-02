public class ParteReused {
	int total;
	int  items;
	int base;
	
	public void ParteReused(){
		this.total=0;
		this.items=0;
		this.base=0;
	}
	public void ParteReused(int total, int items, int base){
		this.total=total;
		this.items=items;
		this.base=base;
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
	public void getNum(String file){
		
	}

}
