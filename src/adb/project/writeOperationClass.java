/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package adb.project;

import com.sun.javafx.util.TempState;
import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author Munib
 */
public class writeOperationClass {
    
    String Resourcename;
    Stack<Integer> transactionStack;
    Stack<Integer> valueStack;
    boolean inTable;
    Stack<Boolean> isBeenToTable;
    public writeOperationClass(int Tno, int value, String rn) {
        transactionStack= new Stack<>();
        valueStack= new Stack<>();
        isBeenToTable= new Stack<>();
        setValues(value);
        setTrans(Tno);
        TruthStack(false);
        this.Resourcename=rn;
        this.inTable=false;
    }
    void addBool(boolean status)
    {
        isBeenToTable.push(false);
    }
    int getTransactionNumber()
    {
        return transactionStack.peek();
    }
    int nextVal()
    {
        int x,x2;
        x=valueStack.pop();
        x2=valueStack.peek();
        valueStack.push(x);
        return x2;
    }
    void TruthStack(boolean b)
    {
        isBeenToTable.push(b);
    }
    int getValue()
    {
        return valueStack.peek();
    }
    String getResourceName()
    {
        return this.Resourcename;
    }
    void setResouceName(String s)
    {
        this.Resourcename=s;
        
    }
    void setAllToTrue()
    {
        boolean v;
        Stack <Boolean> temp = new Stack<>();
        while(!isBeenToTable.isEmpty())
        {
            v=isBeenToTable.pop();
            if(v)
            {
                isBeenToTable.push(v);
                break;
            }
            temp.push(v);
        }
        while(!temp.isEmpty())
        {
            isBeenToTable.push(true);
            temp.pop();
        }
        
    }
    String ReturnPrevValues()
    {
        this.nowInTable();
        boolean v;
        Stack <Boolean> temp = new Stack<>();
        Stack <Integer> tempvalues= new Stack();
        Stack <Integer> temptrans= new Stack();
        
        while(!isBeenToTable.isEmpty())
        {
            v=isBeenToTable.pop();
            if(v)
            {
                isBeenToTable.push(v);
                break;
            }
            temp.push(v);
            tempvalues.push(valueStack.pop());
            temptrans.push(transactionStack.pop());
        }
        
        String s=new String();
        
        while(!temp.isEmpty())
        {
            if(s.isEmpty())
                s="Added Resource: "+this.Resourcename+" with value: "+tempvalues.peek()+" by transaction T"+(temptrans.peek()!=0?temptrans.peek():"(Default)");
            else
                s=s+",Added Resource: "+this.Resourcename+" with value: "+tempvalues.peek()+" by transaction T"+(temptrans.peek()!=0?temptrans.peek():"(Default)");
            isBeenToTable.push(true);
            valueStack.push(tempvalues.pop());
            transactionStack.push(temptrans.pop());
            temp.pop();
        }
        return s;
    }
    void setValues(int v)
    {
        this.valueStack.push(v);
    }
    void setTrans(int t)
    {
        this.transactionStack.push(t);
    }
    
    boolean isInTable()
    {
        
        return this.inTable;
    }
    void nowInTable()
    {
        this.inTable=true;
    }
    void notInTableNow()
    {
        this.inTable=false;
    }
    
    boolean removeTopData()
    {
        if(valueStack.isEmpty() || transactionStack.isEmpty())
            return false;
        this.valueStack.pop();
        this.transactionStack.pop();
        return true;
    }
    
}
