/**
 * An Order contains a product and the quantity.
 * The price is calculated based on the price policy
 * and by default, the price policy is 'Buy One Get One Free
 * and it implemented by the getCostMethod'
 * @author p15237108
 *
 */
public class Order implements Comparable<Order>, PricePolicy {

	//fields
	private int quantity;  // the number of products
	private int cost; //to store the cost
	private Product product; // the product
	private PricePolicy policy;

	//constructors
	/**
	 * Default constructor the product to its default and the quantity to 0
	 */
	public Order(){
		this(0, new Product());
	}

	/**
	 * Custom constructor constructs an order with the
	 * given quantity and product.
	 * @param quantity the identifier for the number of products
	 * @param product the identifier for the product
	 */
	public Order(int quantity, Product product) {
		this.quantity = quantity;
		this.product = product;

		/*the default price policy is set to quantity X price
		 * Please note that the variables 'quant' was
		 * used instead of 'quantity' to avoid clashing of the 
		 * variable 'quantity' already inside constructor*/
		policy = (quant, price) -> quant * price;
	}


	//methods

	/**Returns the textual representation of the product
	 * @return the textual representation of the product
	 */
	public Product getProduct() {
//		Product p = null;
//		if (product.getClass() == Product.class){
//			p = product;
//		}
//		if (product.getClass() == DiscountProduct.class){
//			p = (DiscountProduct) product;
//		}
//		
//		return p;
		return product;
	}

	/**Sets the product for the order
	 * @param product the product to be used
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**Returns the value of the quantity of a product in the order
	 * @return the value of the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**Sets the value of the quantity of a product in the order
	 * @param quantity The number of items to be ordered
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**Increases the value of the quantity by one
	 */
	public void increaseQuantity(){
		quantity++;
	}

	/**Increases the value of the quantity by the amount inputed
	 *  @param amount The value to increase the quantity by
	 */
	public void increaseQuantity(int amount){
		quantity += amount;
	}

	/**Decreases the value of the quantity by one
	 */
	public void decreaseQuantity(){
		//check if quantity is not zero
		if (quantity != 0){
			quantity--;
		}
		if (quantity == 0){
			quantity = 0;
		}
	}

	/**Decreases the value of the quantity by the amount inputed
	 *  @param amount The value to increase the quantity by
	 */
	public void decreaseQuantity(int amount){
		//check if quantity is not zero
		if (quantity != 0){
			quantity -= amount;
		}
		if (quantity == 0){
			quantity = 0;
		}
	}
	
	/**Returns the product of the price and quantity
	 * price is gotten from the product using the
	 * getUnitPrice() method of the product class
	 * @return The product of the price and quantity of the product
	 */
	public int getCost()
	{
		int price = product.getUnitPrice();
		cost = this.CalculateCost(quantity, price);
		return cost;
//		return cost = policy.CalculateCost(quantity, price);
	}

	/**Returns the value of the comparisons
	 * @return The value of the comparisons
	 */
	@Override
	public int compareTo(Order other) {
		int result = this.product.compareTo(other.product);
		if (result == 0){ //products are the same
			result = Integer.compare(quantity, other.quantity);
		}
		return result;
	}
	
	/**Checks for equality
	 * @param The object to check for equality
	 * @return true or false
	 */
	public boolean equals(Object obj){
		if (this.getClass() != obj.getClass() || obj == null)
			return false;
		Order other = (Order) obj;
		return this.product.equals(other.product);

	}
	/**Returns a textual representation of the Order class
	 * @return A textual representation of the Order class
	 */
	@Override
	public String toString() {
		return "Order [quantity=" + quantity + ", " + product + " cost=" + this.getCost() + "]";
		//		return String.format("Quantity %5d", quantity + "%8s", product + "Cost %5d", cost);
	}

	/**Sets the price policy for the order
	 *
	 * @param policy The policy to set it.
	 */
	public void setPricePolicy(PricePolicy policy){
		this.policy = policy;
	}

	/**
	 * Accepts quantity and price as parameters and returns the 
	 * calculation of the cost based on the price policy
	 * 
	 * @param quantity The quantity of the order.
	 * @param price The unit price of the product in the order
	 * @return The value of the cost calculated based on the policy.
	 */
	@Override
	public int CalculateCost(int quantity, int price) {
		/*switch(policyName){
		case defaultP:
			cost = quantity * price;
			break;
		case B1G1F:
			cost = (quantity/2) * (price);
			break;
		case B2G1F:
			cost = (quantity - (quantity/2))*price;
			break;
		case B5G1F:
			cost = (quantity - (quantity/5))*price;
			break;
		}
		return cost;*/
		
		/*switch(policyName){
		case defaultP:
			policy = (quant, amount) -> quant * amount;
			break;
		case B1G1F:
			policy = (quant, amount) -> (quant/2) * amount;
			break;
		case B2G1F:
			policy = (quant, amount) -> (quant - (quant/2)) * amount;
			break;
		case B5G1F:
			policy = (quant, amount) -> (quant - (quant/5)) * amount;
			break;
			
		}*/
		return policy.CalculateCost(quantity, product.getUnitPrice());

		
	}


	
	
	
	
	
	
}


