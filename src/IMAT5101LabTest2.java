import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IMAT5101LabTest2 {

	public static void main(String[] args) throws FileNotFoundException {

		//creating fields
		String firstName;
		String lastName;
		String customerId;
		String cartId;
		String productCode;
		String description;

		int day, month, year;
		int unitPrice;
		int quantity;
		double discount;

		Customer customer;
		Date date;
		Cart ImatCart = new Cart();
		Order order1 = new Order();
		Order order2 = new Order();
		Order order3 = new Order();
		Order order4 = new Order();
		Order order5 = new Order();

		//Creating a new scanner object
				Scanner sc = new Scanner(new File("Input.txt"));

		System.out.println("READING FROM TEXT FILE.............\n");
		while (sc.hasNext()){

			//reading customer details
			firstName = sc.next();
			lastName = sc.next();
			customerId = sc.next();
			customer = new Customer(new Name(firstName, lastName), customerId);

			//reading date details
			day = sc.nextInt();
			month = sc.nextInt();
			year = sc.nextInt();
			date = new Date(day, month, year);

			//reading cart details
			cartId = sc.next();
			ImatCart.setCartId(cartId);
			ImatCart.setCustomer(customer);
			ImatCart.setDate(date);

			// reading the products
			productCode = sc.next();
			description = sc.next();
			unitPrice = sc.nextInt();
			quantity = sc.nextInt();
			order1 = new Order(quantity, new Product(productCode,description, unitPrice));

			productCode = sc.next();
			description = sc.next();
			unitPrice = sc.nextInt();
			quantity = sc.nextInt();
			order2 = new Order(quantity, new Product(productCode,description, unitPrice));

			productCode = sc.next();
			description = sc.next();
			unitPrice = sc.nextInt();
			discount = sc.nextDouble();
			quantity = sc.nextInt();
			order3 = new Order(quantity, new DiscountProduct(productCode,description, unitPrice, discount));

			productCode = sc.next();
			description = sc.next();
			unitPrice = sc.nextInt();
			quantity = sc.nextInt();
			order4 = new Order(quantity, new Product(productCode,description, unitPrice));

			productCode = sc.next();
			description = sc.next();
			unitPrice = sc.nextInt();
			discount = sc.nextDouble();
			quantity = sc.nextInt();
			order5 = new Order(quantity, new DiscountProduct(productCode,description, unitPrice, discount));

		}
		
				//adding the orders to the cart
				ImatCart.addOrder(order1);
				ImatCart.addOrder(order2);
				ImatCart.addOrder(order3);
				ImatCart.addOrder(order4);
				ImatCart.addOrder(order5);

				//printing the order details
				System.out.println(ImatCart.toString() + "\n");

				//Outputting total cost and number of orders in the cart
				System.out.println("\nTotal cost = " + ImatCart.getTotalCost() + " pence");
				System.out.println("Number of Orders is = " + ImatCart.numberOfOrders() + "\n");

				for(Order o : ImatCart){
					System.out.println(o.toString());
				}

	}

}
