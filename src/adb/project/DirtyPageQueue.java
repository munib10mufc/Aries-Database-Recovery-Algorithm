/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package adb.project;

import java.util.LinkedList;

/**
 *
 * @author Munib
 */
public class DirtyPageQueue {
    
    LinkedList<dirtyPageRow> info= new LinkedList<>();
    
    public DirtyPageQueue(int lsn,String T) {
        AddData(lsn, T);
    }
    
    void AddData(int acc,String T)
    {
      info.addLast(new dirtyPageRow(acc, T));
    }
    String getTransNumber()
    {
        if(!info.isEmpty())
            return info.peek().getTransactionName();
        return null;
    }
    
    int getLastAccess()
    {
        if(!info.isEmpty())
            return info.peek().getLastAccess();
        return -1;
    }
    
    void removeFromTop()
    {
        info.pop();
    }
    
    boolean transactionExists(String name)
    {
        LinkedList<dirtyPageRow> templist= new LinkedList<>();
        boolean exists=false;
        while(!info.isEmpty())
        {
            if(info.peek().getTransactionName().equals(name))
            {
                exists=true;
            }
            templist.addLast(info.pop());
        }
        
        while(!templist.isEmpty())
        {
            info.addLast(templist.pop());
        }
        return exists;
    }
    
}
