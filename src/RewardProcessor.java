import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;
/**RewardProcessor class store some products that can be rewarded.
 * It compares the products stored with those in the customer's cart
 * If reward products are found, the reward is the sum of the quantity
 * of the product in the order. This value is then added to the customer
 * as the reward points
 *
 * @author p15237108
 *
 */
public class RewardProcessor {
	//field
	Set<Product> product; // HashSet to store products

	private int rewardPoint; //declaration of a variable to hold reward points

	//constructor
	/**Default Constructor. Initialises the product
	 */
	public RewardProcessor(){
		product = new HashSet<>();
		rewardPoint = 0;
	}

	//method
	/**Adds product to the HashSet
	 * @param The product to be entered
	 * @return The addition of a product to the HashSet
	 */
	public boolean addProduct(Product p){
		return product.add(p);
	}

	/**Calculates the reward points on items of a cart
	 * and returns the value of the rewardPoints
	 * @param c The cart to be rewarded
	 * @return The value of the reward point
	 */
	public int rewardPoints(Cart c){

		/*iterate through each element in the product
		 * and check if the elements in the car matches it.
		 * If the condition is satisfied then the 'if'
		 * expression is executed which adds the quantity to
		 * the variable rewardPoint.*/
		Iterator<Product> itr = product.iterator();
		while (itr.hasNext()){
			Product p =  itr.next(); // assign the current product to p
			for (Order o : c){ //iterate over orders in the cart c
				if (o.getProduct().getProductCode().equals(p.getProductCode())){
					rewardPoint = rewardPoint + o.getQuantity();
				}
			}
		}

		//adds reward point to the customer's cart
		c.getCustomer().addRewardPoints(rewardPoint);

		//returns the total reward points
		return rewardPoint;

	}

//   	/**Checks for equality
//	 * @param The object to check for equality
//	 * @return true or false
//	 */
//	@Override
//	public boolean equals(Object obj){
//		if (this.getClass() != obj.getClass() || obj == null)
//		return false;
//
//		//compares the reward points
//		RewardProcessor other = (RewardProcessor) obj;
//		return this.rewardPoint == other.rewardPoint;
//
//	}

	/**Returns The set of products that can be rewarded
	 * @return The set of products that can be rewarded
	 */
	@Override
	public String toString() {
		
		/*!!!PLEASE NOTE!!!
		 * This code was gotten from
		 * http://stackoverflow.com/questions/395401/printing-java-
		 * collections-nicely-tostring-doesnt-return-pretty-output*/
		String s = product.stream().map(Object::toString).collect(Collectors.joining("\n"));
		
		return "RewardProcessor [product=" + s + "";
	}
}



















