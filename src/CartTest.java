import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Comparator;
/**This is a CartTest. It has a cart
 * The cart has a customer and a delivery date with a cartId
 * Orders are put into the cart. The orders can be retrieved,
 * increased, decreased, removed, cleared and various other implementations
 * available from the classes it uses. Also the totals cost
 * can be calculated and printed out.
 *
 * @author p15237108
 *
 */
public class CartTest {

	public static void main(String[] args) throws FileNotFoundException {

		System.out.println();
		System.out.println("\t*****************************");
		System.out.println(  "\t*                           *");
		System.out.println(    "\t*    SHOPPING CART SYSTEM   *");
		System.out.println(    "\t*    ====================   *");
		System.out.println(  "\t*                           *");
		System.out.println( "\t*****************************");
		System.out.println();

		//Create a new instance of Customer
		Customer customer1 = new Customer(new Name("Francis", "Henshaw"), "s50");
		//Create a new instance of Date
		Date date1 = new Date (01, 01, 2016);
		//Create a new instance of Cart
		Cart myCart = new Cart("s001", customer1, date1);

		//print the cart details
		System.out.println(myCart.toString() + "\n\n");

		//Creating default policy
		//System.out.println("Creating default policy");
		//PricePolicy defaultPolicy 	= (quantity, price) -> quantity*price;

		//Create new instance of Orders
		Order o1 = new Order(3, new Product("pq1", "qualcomm", 79));
		Order o2 = new Order(4, new DiscountProduct("pn4", "nvidia", 85, 0.2));
		Order o3 = new Order(40, new DiscountProduct("pm6", "mediatek", 70, 0.3));
		Order o4 = new Order(20, new Product("pi7", "intel", 1500));
		Order o5 = new Order(30, new Product("pa9", "amd", 7000));
		Order o6 = new Order(32, new Product("par", "arduino", 640));
		Order o7 = new Order(4, new DiscountProduct("pm4", "pi", 55, 0.5));
		Order o8 = new Order(4, new DiscountProduct("poe", "elec", 75, 0.3));
		Order o9 = new Order(3, new Product("pp1", "quadc", 79));

		//myCart.forEach(o -> o.setPricePolicy(defaultPolicy));

		//add orders to the cart
		myCart.addOrder(o1);
		myCart.addOrder(o2);
		myCart.addOrder(o3);
		myCart.addOrder(o4);
		myCart.addOrder(o5);
		myCart.addOrder(o6);
		myCart.addOrder(o7);
		myCart.addOrder(o8);
		myCart.addOrder(o9);

		//for (Order o : myCart){
		//	o.CalculateCost(o.getQuantity(), o.getProduct().getUnitPrice());
		//}

		//Usecase one
		//[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[]]]
		//[]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]][[[[[[[[]]
		System.out.println("*********USECASE 1*********");
		System.out.println("---------------------------");


		//prints out all orders in the cart
		System.out.println("Printing out all orders in the cart");
		myCart.forEach(c -> System.out.println(c));
		System.out.println("\n");

		/*Getting total order and total cost
		 * Please note that this can be done with methods
		 * from the cart class as is shown further in the testing*/
		System.out.println("Printing the order, "
				+ "and calculating the total order and totalprice");
		int count = 0; // to store the number of orders
		int totalPrice = 0;// to store the total cost

		for(Order o: myCart){
			System.out.println(o);
			count++;
			totalPrice += o.getCost();
		}

		System.out.println("The total price = " + totalPrice);
		System.out.println("The number of orders is = " + count);





		//Usecase two
		//[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[]]]
		//[]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]][[[[[[[[]]
		System.out.println("\n\n*********USECASE 2*********");
		System.out.println("---------------------------");

		// sort all orders
		System.out.println("Testing the sortOrders method...............");
		myCart.sortOrders();

		System.out.println("\nPrinting after sorting");
		//prints out all orders in the cart after sorting
		myCart.forEach(c -> System.out.println(c));

		//sort orders in the cart using custom comparator method
		//sort by cost first, then the product in reverse order.
		System.out.println("\nTesting the sortOrders method with custom sort.....");
		myCart.sortOrder(Comparator.comparing(Order::getCost)
				.thenComparing(Order::getProduct, Comparator.reverseOrder()));

		//prints out all orders in the cart after custom sort
		System.out.println("\nPrinting after sorting");
		myCart.forEach(c -> System.out.println(c));

		//check number of orders
		System.out.println("\nTesting the numberOfOrders method.....");
		System.out.println("Number of orders = " + myCart.numberOfOrders());





		//Usecase three
		//[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[]]]
		//[]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]][[[[[[[[]]
		System.out.println("\n\n*********USECASE 3*********");
		System.out.println("---------------------------");

		// testing the remove order method
		//remove order at index 2
		System.out.println("\nTesting the removeOrder method");
		System.out.println("Removing one order.........");
		myCart.removeOrder(2);


		System.out.println("\nPrinting After removing an order");
		////prints out all orders in the cart after removing an order
		myCart.forEach(c -> System.out.println(c));

		//check number of orders after removing one
		System.out.println("\nThe number of orders should be less than one now");
		System.out.println("Number of orders = " + myCart.numberOfOrders());

		//clear all orders from the cart
		System.out.println("\nTesting the clearOrder method....");
		myCart.clearOrder();

		//check if the cart contains any order
		System.out.println("\nTesting the containsOrder method");
		System.out.println("Answer should be false");
		System.out.println("Contains order? " + myCart.containsOrder());

		//add some orders to cart again
		System.out.println("\nAdding an Order to the cart again......");
		myCart.addOrder(o2);
		System.out.println("\nAn Order is added to cart");

		//check if the cart contains any order
		System.out.println("\nRe-Testing the containsOrder method");
		System.out.println("Contains order? " + myCart.containsOrder());

		//add all orders back to the cart
		System.out.println("\nAdding all orders back to the cart");
		myCart.addOrder(o1);
		myCart.addOrder(o3);
		myCart.addOrder(o4);
		myCart.addOrder(o5);
		myCart.addOrder(o6);
		myCart.addOrder(o7);
		myCart.addOrder(o8);
		myCart.addOrder(o9);

		//check number of orders in the cart again
		System.out.println("\nTesting numberOfOrders method again");
		System.out.println("number of Orders = " + myCart.numberOfOrders());

		//using findOrder method of the Cart's class
		System.out.println("Using the findOrder method");
		System.out.println("Searching order with productCode \"pq1\"........");
		System.out.println("Order found:  " + myCart.findOrder("pq1"));
		System.out.println("Searching order with productCode \"pa9\"........");
		System.out.println("Order found:  " + myCart.findOrder("pa9"));
		System.out.println("Searching order with productCode \"po9\"........");
		System.out.println("Order NOT found!!!:  " + myCart.findOrder("po9"));

		//create new PrintWriter object and define a file
		System.out.println("\n\n=======================");
		System.out.println("Using the PrintWriter\n");
		PrintWriter pw = new PrintWriter(new File("Cart.txt"));
		pw.println("The PrintWriter Test");
		pw.println();
		pw.println("\t*****************************");
		pw.println(  "\t*                           *");
		pw.println(    "\t*    SHOPPING CART SYSTEM   *");
		pw.println(    "\t*    ====================   *");
		pw.println(  "\t*                           *");
		pw.println( "\t*****************************");
		pw.println();
		pw.println();
		pw.println();
		pw.println(myCart.toString() + "\n");
		pw.println();
		for (Order p: myCart){
			pw.println(p);
		}
		pw.println("\nNumber of orders = " + myCart.numberOfOrders());
		pw.println("Total cost = " + myCart.getTotalCost() + " pence");
		pw.println("\n\n\t\t_________________________________");
		pw.println("\t\t---------------------------------");
		pw.println("\t\t||                             ||");
		pw.println("\t\t|| \\\\     SHOPPING CART      //||");
		pw.println("\t\t||   \\\\____________________//  ||");
		pw.println("\t\t||     -------$$$$$$-------    ||");
		pw.println("\t\t||          [========]         ||");
		pw.println("\t\t||            SYSTEM           ||");
		pw.println("\t\t||            CLOSED           ||");
		pw.println("\t\t||-----------------------------||");
		pw.println("\t\tL+'''''''''''''''''''''''''''''+J");
		pw.flush();
		pw.close();

		System.out.println("#################################");
		System.out.println("   Printing to file Complete     ");
		System.out.println("#################################");


		//Usecase four
		//[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[]]]
		//[]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]][[[[[[[[]]
		System.out.println("\n\n******** USECASE 4 ********");
		System.out.println("---------------------------");

		//Testing some other methods in the cart and order
		System.out.println("\nTesting other methods.....\n");

		System.out.println("Testing the getCartId method");
		System.out.println("CartId = " + myCart.getCartId() + "\n");

		System.out.println("Testing the getTotalCost method");
		System.out.println("Total Cost = " + myCart.getTotalCost() + " pence");

		System.out.println("\nTesting the increaseQuantity method on all orders");
		System.out.println("The quantity of all orders should increase by one");
		for(Order p : myCart){
			p.increaseQuantity();
		}

		System.out.println("\n\nPrinting after increasing quantity");
		myCart.forEach(c -> System.out.println(c));

		System.out.println("\nTesting the decreaseQuantity method on all orders");
		System.out.println("The quantity of all orders should decrease by one");
		for(Order p : myCart){
			p.decreaseQuantity();
		}

		System.out.println("\nPrinting after decreasing quantity");
		myCart.forEach(c -> System.out.println(c));

		System.out.println("\nTesting the increaseQuantity with parameter method on all orders");
		System.out.println("The quantity of all orders should increase by five");
		for(Order p : myCart){
			p.increaseQuantity(5);
		}

		System.out.println("\nPrinting after increasing quantity by five");
		myCart.forEach(c -> System.out.println(c));

		System.out.println("\nTesting the decreaseQuantity with parameter method on all orders");
		System.out.println("The quantity of all orders should decrease by one");
		for(Order p : myCart){
			p.decreaseQuantity(4);
		}

		System.out.println("\nPrinting after decreasing quantity by five");
		myCart.forEach(c -> System.out.println(c));

		System.out.println("\nIncreasing the fourth order on the list by four");
		System.out.println("The fourth order should increase by four");
		myCart.getOrder(4).increaseQuantity(4);

		System.out.println("\nPrinting after increasing quantity of fourth order by four");
		myCart.forEach(c -> System.out.println(c));

		System.out.println("\ndecreasing the sixth order on the list by one");
		System.out.println("The sixth order should increase by one");
		myCart.getOrder(6).decreaseQuantity();

		System.out.println("\nPrinting after decreasing quantity of sixth order by one");
		myCart.forEach(c -> System.out.println(c));




		//Usecase five
		//[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[]]]
		//[]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]][[[[[[[[]]
		System.out.println("\n\n******** USECASE 5 ********");
		System.out.println("---------------------------");

		System.out.println("\nCreating two reward products....."
				+ "with product code pq1 and pi7");
		Product p1 = new Product("pq1", "qualcomm", 79);
		Product p2 = new Product("pi7", "intel", 1500);

		//An instance of reward processor
		System.out.println("\nAdding the two product to rewardProcessor instance.....");
		RewardProcessor reward = new RewardProcessor();
		reward.addProduct(p1);
		reward.addProduct(p2);

		System.out.println("\nAdding reward points to the already existing "
				+ "\ncart using the rewardPoints method...");
		System.out.println("Reward points generated = " + reward.rewardPoints(myCart));

		System.out.println("\nPrinting the rewardable products");
		System.out.println(reward.toString());

		System.out.println("\nTesting the getRewardPoints of the Customer class");
		System.out.println("reward points for" + customer1 + " = " + customer1.getRewardPoints());

		System.out.println("\nIncreasing the quantity of all orders in the customer's cart by two... "
				+ "\nthis should in crease the reward point by 25 + 8");
		myCart.forEach(o -> o.increaseQuantity(4));

		System.out.println("\nGenerating the reward points and adding it to the existing 25 points");
		System.out.println("Reward points generated = " + reward.rewardPoints(myCart));


		//Usecase six
		//[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[]]]
		//[]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]][[[[[[[[]]
		System.out.println("\n\n******** USECASE 6 ********");
		System.out.println("---------------------------");

		System.out.println("\nCreating new policies.........");
		PricePolicy B1G1F 			= (quantity, price) -> (quantity/2) * (price);
		PricePolicy B2G1F 			= (quantity, price) -> (quantity - (quantity/2))*price;
		PricePolicy B5G1F 			= (quantity, price) -> (quantity - (quantity/5))*price;

		System.out.println("\nCreating new set of orders");
		Order oo1 = new Order(30, new Product("pa9", "amd", 7000));
		Order oo2 = new Order(32, new Product("par", "arduino", 640));
		Order oo3 = new Order(4, new DiscountProduct("pm4", "pi", 55, 0.5));
		Order oo4 = new Order(4, new DiscountProduct("poe", "elec", 75, 0.3));

		//Applying the policies to the orders using the setPolicy method
		System.out.println("\nApplying the different policies......");
		System.out.println("\nUsing the default policy");
		//oo1.setPricePolicy(defaultPolicy);
		System.out.println("Order 1 = " + oo1.toString());

		System.out.println("\nUsing the buy-one-get-one-free policy");
		oo2.setPricePolicy(B1G1F);
		System.out.println("Order 2 = " + oo2.toString());

		System.out.println("\nUsing the buy-two-get-one-free policy");
		oo3.setPricePolicy(B2G1F);
		System.out.println("Order 3 = " + oo3.toString());

		System.out.println("\nUsing the buy-five-get-one-free policy");
		oo4.setPricePolicy(B5G1F);
		System.out.println("Order 4 = " + oo4.toString());

		System.out.println("\nCreating a cart to store all the orders...");


		//Create a new instance of Customer
		Customer customer2 = new Customer(new Name("Joe", "Bloggs"), "j90");
		//Create a new instance of Date
		Date date2 = new Date (04, 01, 2016);
		//Create a new instance of Cart
		Cart myPolicyCart = new Cart("s005", customer2, date2);

		System.out.println("\nAdding all the orders with different policies to the cart....");
		myPolicyCart.addOrder(oo1);
		myPolicyCart.addOrder(oo2);
		myPolicyCart.addOrder(oo3);
		myPolicyCart.addOrder(oo4);

		System.out.println("\nClarification..................");
		System.out.println("The first item uses the default policy");
		System.out.println("The second item uses the buy-one-get-one-free policy");
		System.out.println("The third item uses the buy-two-get-one-free policy");
		System.out.println("The foruth item uses the buy-five-get-one-free policy");

		System.out.println("\nIncreasing the quantity of all orders in the cart by five");
		myPolicyCart.forEach(o -> o.increaseQuantity(5));

		System.out.println("\nPrinting out all the orders and their prices");

		/*Using a for loop here so that each order
		 * would be numbered as they are printed out*/
		int counts = 0; //a variable to store count
		for (int i = 0; i < myPolicyCart.numberOfOrders(); i++){
			System.out.println("Order" + ++counts + " = " + myPolicyCart.getOrder(i));
		}

		//This should affect the prices of the orders except the one using the policy already
		System.out.println("Setting all orders to use the buy-one-get-one-free policy");
		myPolicyCart.forEach(o -> o.setPricePolicy(B1G1F));

		System.out.println("\nPrinting out all the orders and their prices again...");
		System.out.println("Price of Order 2 should remain the same");

		/*Using a for loop here so that each order
		 * would be numbered as they are printed out*/
		int counting = 0; //a variable to store count
		for (int i = 0; i < myPolicyCart.numberOfOrders(); i++){
			System.out.println("Order" + ++counting + " = " + myPolicyCart.getOrder(i));

		}

		System.out.println("\n\n\t\t_________________________________");
		System.out.println("\t\t---------------------------------");
		System.out.println("\t\t||                             ||");
		System.out.println("\t\t|| \\\\     SHOPPING CART      //||");
		System.out.println("\t\t||   \\\\____________________//  ||");
		System.out.println("\t\t||     -------$$$$$$-------    ||");
		System.out.println("\t\t||          [========]         ||");
		System.out.println("\t\t||            SYSTEM           ||");
		System.out.println("\t\t||            CLOSED           ||");
		System.out.println("\t\t||-----------------------------||");
		System.out.println("\t\tL+'''''''''''''''''''''''''''''+J");

	}


}
