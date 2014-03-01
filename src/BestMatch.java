/*This module consists of the functions which generate the combinations of the products and chooses the best combination*/

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class BestMatch
{  
  static public <E> Set<Set<E>> computeKPowerSet(final Set<E> source, final int k)
  {
    if (k==0 || source.size() < k) {
      Set<Set<E>> set = new HashSet<>();
      set.add(Collections.EMPTY_SET);
      return set;
    }

    if (source.size() == k) {
      Set<Set<E>> set = new HashSet<>();
      set.add(source);
      return set;
    }

    Set<Set<E>> toReturn = new HashSet<>();

    // distinguish an element
    for(E element : source) {
      // compute source - element
      Set<E> relativeComplement = new HashSet<>(source);
      relativeComplement.remove(element);

      // add the powerset of the complement
      Set<Set<E>> completementPowerSet = computeKPowerSet(relativeComplement,k-1);
 
      toReturn.addAll(withElement(completementPowerSet,element));
    }

    return toReturn;
  }

  /** Given a set of sets S_i and element k, return the set of sets {S_i U {k}} */ 
  static private <E> Set<Set<E>> withElement(final Set<Set<E>> source, E element)
  {

    Set<Set<E>> toReturn = new HashSet<>();
    
    for (Set<E> setElement : source) {
      Set<E> withElementSet = new HashSet<>(setElement);
      withElementSet.add(element);
      toReturn.add(withElementSet);
    }

    return toReturn;
  }

  public static Set bestSet(ZappoBean[] items, int limit, float target, int noOfItems)
  {
    Set<Integer> source = new HashSet<>();
    HashMap<Integer,Float> m = new HashMap();
    HashMap<Integer,Set<Integer>> combiPrice = new HashMap<>();
    int[] combiTotal = new int[limit];
    int productID;
    /*if(items == null)
    {
    	System.out.println("No Items in the search result");
    }*/
	float productPrice;
    for (int i=0;i<limit;i++)
    {
    	productID =  Integer.parseInt(items[i].getProductId());
    	productPrice = Float.parseFloat(items[i].getPrice());
    	if(productPrice<target)
    	{
    		m.put(productID, productPrice);	
    	}
    	
    }
   
    Set<Integer> keys = m.keySet();
    for (Integer item : keys)
    {
        source.add(item);
    }
    
    Set<Set<Integer>> powerset = computeKPowerSet(source,noOfItems);
    int sum = 0,key=0;
    int i=0;

    for (Set<Integer> set : powerset) {
      for (Integer item : set) {
        //System.out.print(item+" ");
        sum+=m.get(item);
      }
      combiTotal[i]=sum;
      combiPrice.put(sum,set);
      sum = 0;
      i++;
      
    }
    
    Arrays.sort(combiTotal);
    for(i=0;i<combiTotal.length;i++)
    {
        if(target<combiTotal[i])
        {
            key = combiTotal[i];
            break;
        }
    }
    if((target-combiTotal[i-1])<(combiTotal[i]-target))
    {
        key = combiTotal[i-1];
    }
    System.out.println("The sum of all"+ noOfItems +" items is: "+ key);
    return (combiPrice.get(key));
  }
  
  
}

