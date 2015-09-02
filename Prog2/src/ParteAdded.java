public class ParteAdded {
	int total;
	int items;
	
	public void ParteAdded(){
		total=0;
		items=0;
	}
	public void ParteAdded(int total, int items){
		this.total=total;
		this.items=items;
	}
	public void setTotal(int total){
		this.total+=total;
	}
	public int getTotal(){
		return total;
	}
	public void setItems(int items){
		this.items=items;
	}
	public int getItems(){
		return items;
	}
	
	public void getNum(String file){
		
	}

}