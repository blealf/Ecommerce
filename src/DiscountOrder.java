/**The discountOrder Class has a discount quantity and calculates the cost
 *  of the order based on the value of the discount quantity
 *
 * @author p15237108
 *
 */
public class DiscountOrder extends Order {

	//fields
	private int discountQuantity;

	//constructors
	/**Custom constructor, creates an instance of DiscountOrder
	 * with some default values
	 */
	public DiscountOrder(){
		this(0, new Product() ,0);
	}

	/**Custom constructor, creates an instance of DiscountOrder with the
	 * values provided in the parameter
	 *
	 * @param quantity The quantity of the Order
	 * @param product The quantity of the Product
	 * @param discountQuantity The quantity for the discountOrder
	 */
	public DiscountOrder(int quantity, Product product, int discountQuantity) {
		super(quantity, product);
		this.discountQuantity = discountQuantity;
	}

	/**Returns the value of the discountQuantity
	 *
	 * @return the value of the discountQuantity
	 */
	public int getDiscountQuantity() {
		return discountQuantity;
	}

	/**Sets the discount quantity with the value provided in the parameter
	 *
	 * @param discountQuantity The value for the discountQuantity
	 */
	public void setDiscountQuantity(int discountQuantity) {
		this.discountQuantity = discountQuantity;
	}

	/**Returns the cost of the discountOrder calculated with respect to the discountQuantity
	 *
	 *@return The cost of the discountOrder calculated with respect to the discountQuantity
	 */
	@Override
	public int getCost(){
		int cost = 0;
		if (super.getQuantity() >= 10){
			cost = ((super.getQuantity()) -(super.getQuantity()/this.getDiscountQuantity()))
					* super.getProduct().getUnitPrice();
		}

		if ( super.getQuantity() < 10){
			cost = super.getCost();
		}
		return cost;
	}

	/**Returns a textual representation of the DiscountOrder Class
	 *
	 *@return A textual representation of the DiscountOrder Class
	 */
	@Override
	public String toString() {
		return "DiscountOrder [toString()=" + super.toString() + ", discountQuantity=" + discountQuantity
				+ ", getCost()=" + getCost() + "]";
	}

	/**Checks if the discount Quantity for two discount orders are the same.
	 *
	 *@return True or false based on the result
	 */
	public boolean equals(Object obj){
		if (!super.equals(obj))
			return false;

		DiscountOrder other = (DiscountOrder) obj;
		return this.discountQuantity == other.discountQuantity;
	}







}
