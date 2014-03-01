import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 This is the module where the main is present and whole program is executed 
 */
public class SplitForMe {
	/*This function is used to get the budget from the user*/
	static float get_user_budget() throws IOException
    {
       try
       {
           System.out.println("Please Enter your budget: ");
           InputStreamReader isr = new InputStreamReader(System.in);
           BufferedReader br = new BufferedReader(isr);
           float budget; 
           budget = Float.parseFloat(br.readLine());
           if (budget <1)
           {
               System.out.println("Please enter a value greater than or equal to 1");
               budget = get_user_budget();
           }
           
           return budget;
       }
       catch(IOException | NumberFormatException e)
       {
           System.out.println("Please Enter an numeric value");
           float budget = get_user_budget();
           return budget;
       }
        
            
       
    }
	/*This function is used to get the item quantity from the user*/
    static int get_quantity() throws IOException
    {
        try
        {
            System.out.println("Please Enter the quantity: ");
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            int quantity ;
            quantity = Integer.parseInt(br.readLine());
            if (quantity <1)
           {
               System.out.println("Please enter a value greater than or equal to 1");
               quantity = get_quantity();
           }
            return quantity;
        }
        catch(IOException | NumberFormatException e)
       {
           System.out.println("Please Enter an Integer value");
           int quantity = get_quantity();
           return quantity;
       }
       
    }
    
    
    static boolean yes_or_no() throws IOException
    {
        System.out.println("Do you wish to continue? Yes or No: ");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String result = br.readLine();
        if (result.equalsIgnoreCase("yes") || result.equalsIgnoreCase("y"))
        {
            return true;
        }
        if (result.equalsIgnoreCase("no") || result.equalsIgnoreCase("n"))
        {
            return false;
        }
        else
        {
            System.out.println("Please enter a valid input");
            yes_or_no();
        }
        return false;
        
    }
    
    static ZappoBean[] getTheItems(int limit) throws IOException
    {
    	
		ZappoBean[] item = new ZappoBean[limit];
    	item = Zappos.getZapposItemForSearchTerm("http://api.zappos.com/Search?term=bags&key=52ddafbe3ee659bad97fcce7c53592916a6bfd73");
    	return item;
    }
    
    
    static void display(Set<Integer> result, ZappoBean[] items)
    {
    	for (Integer setElement : result)
    	{
    		for (int i=0; i<items.length;i++)
    		{
    			if(setElement == Integer.parseInt(items[i].getProductId()))
    			{
    				System.out.println(items[i].toString());
    			}
    		}
    	}
    	
    }
    
    
    public static void main(String[] args) throws IOException 
    {
    	float budget = get_user_budget();
    	int noOfItems = get_quantity();
    	int limit = 100;
    	ZappoBean[] item = new ZappoBean[limit];
    	item = getTheItems(limit);
        Set<Integer> result = new HashSet<>();
        result = BestMatch.bestSet(item,limit,budget,noOfItems);
        display(result,item);
    	
    	
    }

}
