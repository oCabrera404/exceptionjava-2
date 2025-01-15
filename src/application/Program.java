package application;

import model.entities.Account;
import model.exceptions.BusinessException;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws BusinessException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
        System.out.println("Enter account data: ");
        System.out.print("Number: ");
        int number = sc.nextInt();

        System.out.print("Holder: ");
        sc.next();
        String holder = sc.nextLine();

        System.out.print("Initial balance: ");
        Double initialBalance = sc.nextDouble();

        System.out.print("Withdraw limit: ");
        Double withDrawLimit = sc.nextDouble();

        Account account = new Account(number, holder, initialBalance, withDrawLimit);

        System.out.print("Enter amount for withdraw: ");
        Double amount = sc.nextDouble();
        account.withdraw(amount);

        System.out.println("New balance: " + String.format("%.2f", account.getBalance()));
        }
        catch(BusinessException exception){
            System.out.println(exception.getMessage());
        }
        catch(Exception exception){
            System.out.println("Unexpected error!!!!!");
        }
    }
}