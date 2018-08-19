/**A customer has a name, customerId and reward points
 * from the orders.
 *
 * @author p15237108
 *
 */
public class Customer implements Comparable<Customer>{

	//fields
	private Name customerName;
	private String customerId;
	private int rewardPoints; //reward points initialised here


	//constructors
	// default constructor
	/**Creates a new Customer instance with some default values.
	 */
	public Customer(){
		this(new Name(), "");
	}

	//custom constructor
	/**Creates an instance of Customer with the provided values
	 * @param customerName The name
	 * @param customerId The identifier for customer
	 */
	public Customer(Name customerName, String customerId){
		this.customerName = customerName;
		this.customerId = customerId;
		rewardPoints = 0;
	}

	//methods

	/**Returns the customer's name
	 * @return The customer's name
	 */
	public Name getCustomerName(){
		return customerName;
	}

	/**Sets the customer name with the value provided from a Name class
	 * @param customerName The value from the Name class
	 */
	public void setCustomerName(Name customerName){
		this.customerName = customerName;
	}

	/**Returns the value of the identifier
	 * @return The value of the identifier
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**Sets the identifier of the customer
	 * @param customerId The value of the identifier
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**Returns the value of the rewardPoints
	 * @return The value of the rewardPoints
	 */
	public int getRewardPoints(){
		return rewardPoints;
	}

	/**Adds the amount provided to the rewardPoint
	 * @param amount The value of the amount.
	 */
	public void addRewardPoints(int amount){
		rewardPoints += amount;
	}

	/**Checks for equality
	 * @param The object to check for equality
	 * @return true or false
	 */
	@Override
	public boolean equals(Object obj){
		if (this.getClass() != obj.getClass() || obj == null )
			return false;
		Customer other = (Customer) obj;
		return (this.customerName.equals(other.customerName) && this.customerId == other.customerId);
	}

	/**Returns a textual representation of the Customer class
	 * @return A textual representation of the Customer class
	 */
	@Override
	public String toString() {
		return "Customer [customerName= " + customerName + ", customerId= " + customerId + "]";
	}

	/**Returns the firstname of the customer
	 *
	 * @return The firstname of the customer
	 */
	public String getFirstName(){
		return customerName.getFirstName();
	}

	/**Returns the lastname of the customer
	 *
	 * @return The Lastname of the customer
	 */
	public String getLastName(){
		return customerName.getFamilyName();
	}

	/**Compares the customerId's first and then if they are equal
	 * it compares their firstNames
	 */
	@Override
	public int compareTo(Customer other) {
		int result = customerId.compareTo(other.customerId);
		if (result == 0){
			result = customerName.getFirstName().compareTo(other.customerName.getFirstName());
		}

		return result;
	}




}
