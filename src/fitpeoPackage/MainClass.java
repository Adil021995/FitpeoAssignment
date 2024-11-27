package fitpeoPackage;

public class MainClass 
{
	public static void main(String[] args) throws Exception 
	{
		FitpeoHomepage obj = new FitpeoHomepage();
		obj.openUrl_Meth();
		
		RevenueCalculator obj2 = new RevenueCalculator();
		obj2.revCalculator();
	}
}
