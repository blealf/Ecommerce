import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**A cart is for a customer and has a delivery date and a unique id. It consists
 * of a list of product orders.
 *
 * @author p15237108
 *
 */
public class Cart implements Iterable<Order>{

	//fields
	private String cartId; // The identifier for the cart
	private Customer customer; // the variable for a Customer
	private Date date; // the variable for Date
	private List<Order> orderLine; // variable to store a list of orders

	//constructors
	/**Default constructor. Creates a Cart with some default values
	 */
	public Cart(){
		this("none", new Customer(), new Date());
	}

	/**Creates a cart with values entered
	 * @param cartId The value for the identifier
	 * @param customer The value of the customer
	 * @param date The value of the date
	 */
	public Cart(String cartId, Customer customer, Date date){
		this.cartId = cartId;
		this.customer = customer;
		this.date = date;
		orderLine = new ArrayList<Order>();
	}

	//methods
	/**Returns the value of the cart's identifier
	 * @return The value of the cart's identifier
	 */
	public String getCartId() {
		return cartId;
	}

	/**Sets the value of the cart' identifier to the value entered
	 * @param cartId The value to set the cart's identifier
	 */
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	/**Sets the delivery date for the cart
	 *
	 * @param date The date value to sate
	 */
	public void setDate(Date date){
		this.date = date;
	}

	/**Returns the delivery date for the cart
	 *
	 * @return The delivery date for the cart
	 */
	public Date getDate(){
		return date;
	}

	/**Sets the customer for the cart
	 *
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer){
		this.customer = customer;
	}

	/**Returns the customer of the cart
	 * @return The customer of the cart
	 */
	public Customer getCustomer(){
		return customer;
	}

	/**Returns the value of the Order by position gotten from
	 * the value entered
	 * @param i The value for the position of the order in the cart
	 * @return The value of the order in the cart
	 */
	public Order getOrder(int i){
		return orderLine.get(i);
	}

	/**Adds orders to the orderline by orders entered
	 * @param o The order to add to the orderline
	 */
	public void addOrder(Order o) {
		orderLine.add(o);
	}

	/**Remove an element from the orderline by position entered
	 * if the number of elements is greater than 0
	 * @param i The position of the order
	 */
	public void removeOrder(int i){
		if (this.numberOfOrders() != 0){
			orderLine.remove(i);
		}
	}

	/**Returns the number of elements in the orderline
	 * @return The number of elements in the orderline
	 */
	public int numberOfOrders(){
		return orderLine.size();
	}

	/**Removes all an element from the orderline
	 */
	public void clearOrder(){
		orderLine.clear();
	}

	/**Checks if the orderline contains an element
	 * @return True or false
	 */
	public boolean containsOrder(){
		boolean x = false;
		if (this.numberOfOrders() > 0){
			x = true;
		}
		if (this.numberOfOrders() == 0){
			x = false;
		}

		return x;
	}

	/**Iterates through each element in the orderline,
	 * gets the cost and return their total
	 * @return The total cost for all elements in the order line
	 */
	public int getTotalCost(){
		int total = 0;
		//orderLine.stream().mapToInt(s -> (total += s.getCost()));
		for(Order o : orderLine){
			total += o.getCost();
		}
		return total;
	}

	/**An iterator method to iterates through
	 * all elements in the orderline
	 */
	@Override
	public Iterator<Order> iterator() {

		return orderLine.iterator();
	}

	public Order findOrder(String productCode){
		Order order = new Order();//create new order object
		for (Order o : orderLine){
			if (o.getProduct().getProductCode().equals(productCode)){
				order = o;
			}
		}
		return order;
	}


	/**Sort the elements in the orderline by natural order
	 */
	public void sortOrders(){
		orderLine.sort(Comparator.naturalOrder());
	}

	/**Sort the elements in the orderline by custom comparator method
	 * @param o The custom comparator method to sort
	 * the elements in the orderline
	 */
	public void sortOrder(Comparator<Order> o){
		orderLine.sort(o);
	}


	/**Checks for equality
	 * @param The object to check for equality
	 * @return true or false
	 */
	public boolean equals(Object obj){
		if (this.getClass() != obj.getClass() || obj == null)
			return false;
		Cart other = (Cart) obj;
		//compares only the orders
		return this.orderLine.equals(other.orderLine);
	}

	/**Returns a textual representation of the Cart class
	 * which include the cartId, customer, date and total cost of orders.
	 * @return A textual representation of the Cart class
	 */
	public String toString(){
		return "Cart [ CartID= " + cartId + "\n" + customer.toString()
				+ "\nDelivery date = " + date.toString() + "      Total Cost= "
				+ this.getTotalCost()+ " pence]";
	}

//	public int getIndex(Order o){
//		return this.getIndex(o);
//
//	}

}
