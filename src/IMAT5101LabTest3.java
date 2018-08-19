
public class IMAT5101LabTest3 {

	public static void main(String[] args){

		Customer customer = new Customer(new Name("Julia", "Enya"), "N5424");
		Date date = new Date(19, 01, 2015);
		Cart ImatCart = new Cart("CX4325753", customer, date);

		Order order1 = new Order(3, new Product("511-295","John West Black Lumpfish Caviar", 248));
		Order order2 = new Order(1, new Product("673-293","Finest Beef - Chateaubriand", 3500));
		Order order3 = new Order(2, new DiscountProduct("830-431","Whole Black Truffle", 945, 0.2));
		Order order4 = new Order(4, new Product("665-737","Atlantic Lobster", 1200));
		Order order5 = new Order(10, new DiscountProduct("234-846","Cadbury Freddor", 25, 0.5));

		//adding the orders to the cart
		ImatCart.addOrder(order1);
		ImatCart.addOrder(order2);
		ImatCart.addOrder(order3);
		ImatCart.addOrder(order4);
		ImatCart.addOrder(order5);

		System.out.println(ImatCart.toString() + "\n");

		//Outputting total cost and number of orders in the cart
		System.out.println("\nTotal cost = " + ImatCart.getTotalCost());
		System.out.println("Number of Orders is = " + ImatCart.numberOfOrders() + "\n");

		// printing only the order with 2 in product code
		System.out.println("printing only the order with 2 in product code\n");
		for(Order o : ImatCart){
			if (o.getProduct().getProductCode().contains("2")){
				System.out.println(o.toString());
			}

		}
	}

}
