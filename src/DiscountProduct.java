/**This class "DiscountProduct" gets a discount on the
 * product and calculates the unitPrice based on this
 * The class extends the Product class.
 *
 * @author p15237108
 *
 */
public class DiscountProduct extends Product{

	//fields
	private double discountRate; // the variable for the discount rate

	//constructors
	/**Default Constructor. Creates a Discount product with default values
	 */
	public DiscountProduct(){
		this("", "", 0, 0.0);

	}

	//custom constructor
	/**Creates a Discount product with the values provided
	 * @param productCode The value of the productCode
	 * @param description The value of the description
	 * @param pricePerUnit The value of the pricePerUnit
	 * @param discountRate The value of the discountRate
	 */
	public DiscountProduct(String productCode, String description, int pricePerUnit, double discountRate){
		super(productCode, description, pricePerUnit);

		//ensure that discount value is between o and 1.0
		if (discountRate >=0 && discountRate <= 1)
			this.discountRate = discountRate;
	}

	//methods

	/**Returns the value of the discountRate
	 * @return The value of the discountRate
	 */
	public double getDiscountRate() {
		//returns an integer whole number
		return (int)( discountRate * 100);
	}

	/**Sets the discountRate to the value entered.
	 * @param discountRate The value of the DiscountRate
	 */
	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	/**Calculates and returns the value of the unitPrice with discountRate
	 * @return The value of the calculated unitPrice
	 */
	public int getUnitPrice(){
		return (int) (super.getUnitPrice() - (this.getDiscountRate()/100) *
				super.getUnitPrice());
	}

   	/**Checks for equality
	 * @param The object to check for equality
	 * @return true or false
	 */
	@Override
	public boolean equals(Object obj) {
		if(this.getClass() != obj.getClass() || obj == null)
			return false;
		DiscountProduct other = (DiscountProduct) obj;
		return this.discountRate == other.discountRate;
	}

	/**Returns a textual representation of the DiscountProduct class
	 * @return A textual representation of the DiscountProduct class
	 */
	@Override
	public String toString() {
		return super.toString() + "[discountRate=" + discountRate + "]";
	}



}
