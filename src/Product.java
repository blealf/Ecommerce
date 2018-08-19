/**A Product has a product code, description and unitPrice which can
 * all be accessed using the public methods.
 * Product can also be compared using the compareTo method.
 * @author p15237108
 *
 */
public class Product implements Comparable<Product>{

	//fields
	private String productCode; //identifier for the product
	private String description; // sotres the product description
	private int unitPrice; //price is in pence, so int is appropriate.

	//constructors
	/**Default Constructor. Creates a new instance of a
	 * Product with some default values-empty strings and zero
	 */
	public Product(){
		this("", "", 0);
	}

	//custom constructor
	/**Creates a Product with the supplied values
	 * @param productCode
	 * @param description
	 * @param pricePerUnit
	 */
	public Product(String productCode, String description, int pricePerUnit){
		this.productCode = productCode;
		this.description = description;
		this.unitPrice = pricePerUnit;
	}

	//methods
	/**Returns the value of the productCode
	 * @return The value of the productCode
	 */
	public String getProductCode() {
		return productCode;
	}

	/**Sets the productCode to the value entered
	 * @param productCode The value to set the productCode
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**Returns description of the product.
	 * @return The description of the product.
	 */
	public String getDescription() {
		return description;
	}

	/**Sets the description of the product with string entered.
	 * @param description The value to set the product's description.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**Returns the value of the unitPrice.
	 * @return The value of the unitPrice.
	 */
	public int getUnitPrice() {
		return unitPrice;
	}

	/**Sets the unitPrice to the value entered.
	 * @param pricePerUnit The value of the unitPrice.
	 */
	public void setUnitPrice(int pricePerUnit) {
		this.unitPrice = pricePerUnit;
	}

	/**Compares the product to the one entered.
	 * @return The value of the comparison.
	 */
	@Override
	public int compareTo(Product other) {
		int result = productCode.compareTo(other.productCode);
		if (result == 0) {  //product code are the same
			result = description.compareTo(other.description);
			if (result ==0){  //descriptions are the same
				result = Integer.compare(unitPrice, other.unitPrice);
			}
		}
		return result;
	}

   	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((productCode == null) ? 0 : productCode.hashCode());
		result = prime * result + unitPrice;
		return result;
	}

   	/**Checks for equality
	 * @param The object to check for equality
	 * @return true or false
	 */
	@Override
	public boolean equals(Object obj){
		if ( this.getClass() != obj.getClass() || obj == null)
			return false;

		Product other = (Product) obj;
		return this.productCode == other.productCode && this.description == other.description &&
				this.unitPrice == other.unitPrice;
	}

	/**Returns a textual representation of the Product class
	 * @return A textual representation of the Product class
	 */
	@Override
	public String toString() {
		return this.getClass().getName() + "[ productCode= " + productCode +
				", description=" + description + ", unitPrice=" + unitPrice
				+ " pence" + "]\n";
	}











}
