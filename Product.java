package retrievingproductdetailsbyid;

public class Product {

	private int id;
	private String name;
	private String details;
	public Product(int id, String name, String details) {
		super();
		this.id = id;
		this.name = name;
		this.details = details;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
}
