/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adb.project;

/**
 *
 * @author Munib
 */
public class dirtyPageRow 
{

    String TransactionNumber;
    int lastAccess;
    
    
    public dirtyPageRow(int la, String T) {
        lastAccess=la;
        TransactionNumber=T;
    }
    
    public void addTrans(int la, String T) {
        lastAccess=la;
        TransactionNumber=T;
    }
    
    public int getLastAccess()
    {
        return this.lastAccess;
    }
    public String getTransactionName()
    {
        return this.TransactionNumber;
    }
}
