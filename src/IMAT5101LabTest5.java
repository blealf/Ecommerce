
public class IMAT5101LabTest5 {

	public static void main(String[] args) {

		Customer customer = new Customer(new Name("Julia", "Enya"), "N5424");
		Date date = new Date(19, 01, 2015);
		Cart ImatCart = new Cart("CX4325753", customer, date);

		//Including the discountOrders
		Order order1 = new Order(3, new Product("511-295","John West Black Lumpfish Caviar", 248));
		Order order2 = new Order(1, new Product("673-293","Finest Beef - Chateaubriand", 3500));
		Order order3 = new Order(2, new DiscountProduct("830-431","Whole Black Truffle", 945, 0.2));
		Order order4 = new Order(4, new Product("665-737","Atlantic Lobster", 1200));
		Order order5 = new DiscountOrder(4, new Product("665-737","Atlantic Lobster", 1200), 2);
		Order order6 = new Order(10, new DiscountProduct("834-876","Freddor", 25, 0.5));
		Order order7 = new DiscountOrder(30, new Product("573-777","Pacific Prawn", 1200), 5);
		Order order8 = new DiscountOrder(40, new Product("342-846","Spinach", 25), 5);
		Order order9 = new DiscountOrder(29, new Product("566-757","Java Octopus", 1200), 10);
		Order order10 = new DiscountOrder(10, new Product("432-806","Orange Squid", 25), 10);

		//adding all orders to the cart
		ImatCart.addOrder(order1);
		ImatCart.addOrder(order2);
		ImatCart.addOrder(order3);
		ImatCart.addOrder(order4);
		ImatCart.addOrder(order5);
		ImatCart.addOrder(order6);
		ImatCart.addOrder(order7);
		ImatCart.addOrder(order8);
		ImatCart.addOrder(order9);
		ImatCart.addOrder(order10);

		//printing the cart details
		System.out.println(ImatCart.toString() + "\n");

		//Outputting total cost and number of orders in the cart
		System.out.println("\nTotal cost = " + ImatCart.getTotalCost());
		System.out.println("Number of Orders is = " + ImatCart.numberOfOrders() + "\n");

		for(Order o : ImatCart){
			System.out.println(o.toString() + "\n");
		}
	}

}
