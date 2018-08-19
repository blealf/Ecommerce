import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/**
 *
 * @author p15237108
 *
 */
public class IMAT5101LabTest4 {

	public static void main(String[] args) {

		//new ArrayList
		List<Customer> customer = new ArrayList<>();

		Customer customer1 = new Customer(new Name("Julia", "Enya"), "N5124");
		Customer customer2 = new Customer(new Name("Joe", "Bloggs"), "N5124");
		Customer customer3 = new Customer(new Name("Manuel", "Rice"), "A5222");
		Customer customer4 = new Customer(new Name("Peter", "Squash"), "L5323");
		Customer customer5 = new Customer(new Name("Ted", "Cruz"), "F5424");
		Customer customer6 = new Customer(new Name("Fred", "Cruz"), "S9424");
		Customer customer7 = new Customer(new Name("Joe", "Tind"), "O5453");
		Customer customer8 = new Customer(new Name("Manuel", "Rice"), "Y5222");

		//adding the customers to the list
		customer.add(customer1);
		customer.add(customer2);
		customer.add(customer3);
		customer.add(customer4);
		customer.add(customer5);
		customer.add(customer6);
		customer.add(customer7);
		customer.add(customer8);

		//System.out.println(customer1.compareTo(customer2));

		//using the sort method
		//natural order
		System.out.println("Sorting the Customers using the normal order sort....\n");
		//Collections.sort(customer);
		customer.sort(Comparator.naturalOrder());

		System.out.println("Outputting the result");
		customer.forEach(c -> System.out.println(c));

		//reverse order
		System.out.println("\nSorting the Customers using the reverse order sort....\n");
		customer.sort(Comparator.reverseOrder());

		System.out.println("Outputting the result");
		customer.forEach(c -> System.out.println(c));

		//custom order
		System.out.println("\nUsing the custom sort.... \n");
		customer.sort(Comparator.comparing(Customer::getLastName)
				.thenComparing(Customer::getFirstName)
				.thenComparing(Customer::getCustomerId));

		System.out.println("Outputting the result");
		customer.forEach(c -> System.out.println(c));

	}

}
