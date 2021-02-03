import java.io.IOException;

public class TechSupportGuyMenu {
	
	public static void techSupportGuyMenu(TechSupportGuy tsg) throws NumberFormatException, IOException {
		
		System.out.println("Choose one option: \n" + "1. Accept order\n" + "2. Decline order\n" + "3. View orders\n" + "4. View news\n" + "5. Log out\n");
		int option = Integer.parseInt(Menu.br.readLine());
		
		if (option == 1) {			
			System.out.println(Menu.getData().viewOrders(OrderStatus.PENDING));
			System.out.println("What is the id of Order that you want to accept?");
			int id = Integer.parseInt(Menu.br.readLine());
			Order order = null;
			for (Order o : Menu.getData().getOrders()) {
				if (o.getID() == id)
					order = o;
			}
			if (tsg.acceptOrder(order)) 
				System.out.println("You accepted the order no: " + id);
			techSupportGuyMenu(tsg);
			return;
		}
		
		else if (option == 2) {
			System.out.println(Menu.getData().viewOrders(OrderStatus.PENDING));
			System.out.println("What is the id of Order that you want to decline?");
			int id = Integer.parseInt(Menu.br.readLine());
			Order order = null;
			for (Order o : Menu.getData().getOrders()) {
				if (o.getID() == id)
					order = o;
			}
			if (tsg.declineOrder(order)) 
				System.out.println("You declined the order no: " + id);
			techSupportGuyMenu(tsg);
			return;
		}
		
		else if (option == 3) {
			System.out.println(Menu.getData().viewOrders());
			techSupportGuyMenu(tsg);
			return;
		}
		
		else if (option == 4) {
			System.out.println(tsg.viewNews());
			techSupportGuyMenu(tsg);
			return;
		}
		
		else if (option == 5) {
			Menu.logOut(tsg);
			return;
		}
		else {
			System.out.println("Invalid option");
			techSupportGuyMenu(tsg);
			return;
		}
	}
}
