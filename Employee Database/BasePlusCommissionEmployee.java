import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BasePlusCommissionEmployee extends CommissionEmployee
{
	private double baseSalary; // base salary per week

   // constructor
	public BasePlusCommissionEmployee(String firstName, String lastName,
		String socialSecurityNumber, String birthday, String empType, String
		deptName, double bonus, double grossSales, double commissionRate, double baseSalary)
   {
		super(firstName, lastName, socialSecurityNumber, birthday,
			  "basePlusCommissionEmployee", deptName,
			  bonus, grossSales, commissionRate);

		this.baseSalary = baseSalary;
   }

   public BasePlusCommissionEmployee()
   {
		super();
		empType = "basePlusCommissionEmployee";
		Scanner input = new Scanner(System.in);
		System.out.printf("Enter base salary: ");
		baseSalary = input.nextDouble();
   }

   @Override
   public void addNewEmployee(PreparedStatement statement,
		Connection connection) throws SQLException
	{
		super.addNewEmployee(statement, connection);
		statement = connection.prepareStatement(
		"INSERT INTO basePlusCommissionEmployees " +
		"(socialSecurityNumber, grossSales, commissionRate, "+
		"baseSalary, bonus) VALUES (?, ?, ?, ?, ?)");

		int result = 0;
		statement.setString(1, socialSecurityNumber);
		statement.setDouble(2, grossSales);
		statement.setDouble(3, commissionRate);
		statement.setDouble(4, baseSalary);
		statement.setDouble(5, bonus);

		result = statement.executeUpdate();
		System.out.printf("%s%d%s%n", "Query Ok, ", result, " row affected in basePlusCommissionEmployees table");
	}

} // end class BasePlusCommissionEmployee
