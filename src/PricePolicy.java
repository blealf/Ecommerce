/**PricePolicy is a functional interface that has 
 * one abstract method to calculate cost
 * 
 * @author p15237108
 *
 */
public interface PricePolicy {
	/**
	 * 
	 * @param quantity The value of the quantity
	 * @param price The value of the price
	 * @return the value of the calculated cost
	 */
	public int CalculateCost(int quantity, int price);
}
