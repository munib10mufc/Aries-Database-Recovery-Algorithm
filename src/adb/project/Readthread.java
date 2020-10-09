package adb.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;


public class Readthread extends Thread {
    
    
    JTable outputtable,transTable,dirtyPageTable;
    String data;
    JLabel counter;
    private volatile boolean running;
    static int TTrowindex=0,time=800;
    DefaultTableModel transTableModel,dpModel;
    static HashMap<Integer,ttlRowObj> transactionExists;
    static HashMap<String,Integer> dirtyPageHash;
    static HashMap<String,Integer> innitialValues;
    static HashMap <String,writeOperationClass> tempValues;
    static HashMap <String,DirtyPageQueue> ResourceOnDirtyTable;
    static ArrayList <Integer> ComittedTrans;
    static ArrayList <Integer> abortedTrans;
    String resource;
    JTextArea resultBox;
    static ArrayList <Integer> unComittedTrans;
    Scanner readClassSCanner;
    boolean fromFile;
    public Readthread(JTable obj2,String values,JLabel clabel,JTable transactionTable,JTable dpt,HashMap<String,Integer> innitials,JTextArea t,Scanner scan, boolean ff ) {
        outputtable=obj2;
        data=values;
        counter=clabel;
        running =true;
        transTable= transactionTable;
        dirtyPageTable=dpt;
        transTableModel=(DefaultTableModel) transTable.getModel();
        dpModel= (DefaultTableModel) dpt.getModel();
        transactionExists = new HashMap<Integer,ttlRowObj>();
        dirtyPageHash=new  HashMap<String,Integer>();
        innitialValues=innitials;
        ResourceOnDirtyTable= new HashMap<String,DirtyPageQueue>();
        tempValues= new HashMap<>();
        resultBox=t;
        ComittedTrans = new ArrayList<Integer>();
        
        unComittedTrans = new ArrayList<Integer>();
        abortedTrans = new ArrayList<Integer>();
        ComittedTrans.add(0);
        readClassSCanner= scan;
        fromFile=ff;
        for(Map.Entry<String, Integer> entry : innitials.entrySet())
        {
            tempValues.put(entry.getKey(), new writeOperationClass(0, entry.getValue(), entry.getKey()));
        }
        // ResultMap= new HashMap<>();
        resource= new String();
    }
    
    public void kill()
    {
        running=false;
    }
    @Override
    public void run() {
        String [] tableRow=data.split(",",-1);
        String []  colnames={"Line","Operations",};
        DefaultTableModel tableModel = new DefaultTableModel(0,0);
        tableModel.setColumnIdentifiers(colnames);
        int i=0,x=0,rowindex;
        int rounds=1;
        
        while(rounds-->0)
        {
            if(running)
            {
                if(i==1 && readClassSCanner!=null && readClassSCanner.hasNext())
                {
                    rounds++;
                    String pp= readClassSCanner.nextLine();
                    pp= pp.replaceAll("\\s","");
                    String[] values=pp.split("\\*",-1);
                    if(values.length==2)
                    {
                        InputScreen.inputfield.setText(values[0]);
                        InputScreen.datafield.setText(values[1]);
                        data=InputScreen.inputfield.getText();
                        tableRow=data.split(",",-1);
                        innitialValues.clear();
                        abortedTrans.clear();
                        ComittedTrans.clear();
                        transactionExists.clear();
                        dirtyPageHash.clear();
                        ResourceOnDirtyTable.clear();
                        tempValues.clear();
                        transTableModel.setRowCount(0);
                        dpModel.setRowCount(0);
                        tableModel.setRowCount(0);
                        innitialValues= InputScreen.getDataValues(values[1]);
                        unComittedTrans.clear();
                        ComittedTrans.add(0);
                        resultBox.setText("");
                        counter.setText("");
                        for(Map.Entry<String, Integer> entry : innitialValues.entrySet())
                        {
                            tempValues.put(entry.getKey(), new writeOperationClass(0, entry.getValue(), entry.getKey()));
                        }
                        JOptionPane.showMessageDialog(null, "Adding new schedule from file","New schedule adding",JOptionPane.PLAIN_MESSAGE);
                        
                        outputtable.setModel(tableModel);
                        int k=1;
                        for(String s: tableRow)
                        {
                            if(running)
                            {
                                try {
                                    sleep(time);
                                    if(k%(5+x)==0)
                                    {
                                        rowindex=k;
                                        tableModel.addRow(new Object[] { rowindex++,"Begin_CheckPoint" });
                                        addDataToTable(transactionExists);
                                        addDataToDirtyTable(dirtyPageHash);
                                        convertAllToTrue();
                                        //removeFromTempValues();
                                        addDataToResultBox();
                                        //removeFromDirtyPageTable();
                                        counter.setText(String.valueOf(k++));
                                        tableModel.addRow(new Object[] { rowindex++,"End_CheckPoint" });
                                        counter.setText(String.valueOf(k++));
                                        k=rowindex;
                                        i=x=1;
                                        
                                    }
                                    tableModel.addRow(new Object[] { k,s.trim() });
                                    addToTransactionTable(s.trim(), k);
                                    
                                    counter.setText(String.valueOf(k++));
                                } catch (InterruptedException ex) {
                                    JOptionPane.showMessageDialog(null, "Error occured: "+ex.getMessage(),"Error occured",JOptionPane.ERROR_MESSAGE);
                                    Logger.getLogger(Readthread.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Incorrect Format of data","Incorrect Data Format",JOptionPane.PLAIN_MESSAGE);
                        Home obj= new Home();
                        obj.setVisible(true);
                        this.kill();
                        break;
                    }
                }
                if (i==0 && readClassSCanner!=null && readClassSCanner.hasNext())
                {
                    i=1;
                    rounds++;
                    
                    outputtable.setModel(tableModel);
                    int k=1;
                    for(String s: tableRow)
                    {
                        if(running)
                        {
                            try {
                                sleep(time);
                                if(k%(5+x)==0)
                                {
                                    rowindex=k;
                                    tableModel.addRow(new Object[] { rowindex++,"Begin_CheckPoint" });
                                    addDataToTable(transactionExists);
                                    addDataToDirtyTable(dirtyPageHash);
                                    convertAllToTrue();
                                    //removeFromTempValues();
                                    addDataToResultBox();
                                    //removeFromDirtyPageTable();
                                    counter.setText(String.valueOf(k++));
                                    tableModel.addRow(new Object[] { rowindex++,"End_CheckPoint" });
                                    counter.setText(String.valueOf(k++));
                                    k=rowindex;
                                    i=x=1;
                                    
                                }
                                tableModel.addRow(new Object[] { k,s.trim() });
                                addToTransactionTable(s.trim(), k);
                                
                                counter.setText(String.valueOf(k++));
                            } catch (InterruptedException ex) {
                                JOptionPane.showMessageDialog(null, "Error occured: "+ex.getMessage(),"Error occured",JOptionPane.ERROR_MESSAGE);
                                Logger.getLogger(Readthread.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                else if(i==0)
                {
                 i=1;
                    rounds++;
                    
                    outputtable.setModel(tableModel);
                    int k=1;
                    for(String s: tableRow)
                    {
                        if(running)
                        {
                            try {
                                sleep(time);
                                if(k%(5+x)==0)
                                {
                                    rowindex=k;
                                    tableModel.addRow(new Object[] { rowindex++,"Begin_CheckPoint" });
                                    addDataToTable(transactionExists);
                                    addDataToDirtyTable(dirtyPageHash);
                                    convertAllToTrue();
                                    //removeFromTempValues();
                                    addDataToResultBox();
                                    //removeFromDirtyPageTable();
                                    counter.setText(String.valueOf(k++));
                                    tableModel.addRow(new Object[] { rowindex++,"End_CheckPoint" });
                                    counter.setText(String.valueOf(k++));
                                    k=rowindex;
                                    i=x=1;
                                    
                                }
                                tableModel.addRow(new Object[] { k,s.trim() });
                                addToTransactionTable(s.trim(), k);
                                
                                counter.setText(String.valueOf(k++));
                            } catch (InterruptedException ex) {
                                JOptionPane.showMessageDialog(null, "Error occured: "+ex.getMessage(),"Error occured",JOptionPane.ERROR_MESSAGE);
                                Logger.getLogger(Readthread.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                    
            }
        }
        this.kill();
    }
    private void convertAllToTrue()
    {
        for (Map.Entry<String, writeOperationClass> entry : tempValues.entrySet())
        {
            entry.getValue().setAllToTrue();
        }
    }
    private void addDataToResultBox()
    {
        String s= new String();
        for (Map.Entry<String, writeOperationClass> entry : tempValues.entrySet())
        {
            entry.getValue().nowInTable();
            if(s.isEmpty())
                s=entry.getKey()+"("+entry.getValue().getValue()+")=>T"+(entry.getValue().getTransactionNumber()!=0?entry.getValue().getTransactionNumber():" (Default)");
            else
                s=s+"\n"+entry.getKey()+"("+entry.getValue().getValue()+")=>T"+(entry.getValue().getTransactionNumber()!=0?entry.getValue().getTransactionNumber():" (Default)");
        }
        resultBox.setText(s);
    }
    
    
    void addToTransactionTable(String s,int i)
    {
        int op=returnOperation(s);
        
        int transnumber=getTransactionNumber(s);
        
        switch (op)
        {
            case 1:
                
                if(!transactionExists.isEmpty() )
                    
                    transactionExists.get(transnumber).setState("C");
                else
                    transactionExists.put(transnumber, new ttlRowObj("T"+transnumber,i,"C"));
                
                ComittedTrans.add(transnumber);
                break;
            case 2:
                
                break;
            case 3:
                int  val= returnNewValue(s);
                resource=returnResource(s);
                if(!tempValues.containsKey(resource))
                    tempValues.put(resource, new writeOperationClass(transnumber, val,resource));
                else
                    insertValueInHashMap(transnumber, val,resource);
                if(transactionExists.get(transnumber)==null)
                {
                    transactionExists.put(transnumber,new ttlRowObj("T"+transnumber,i,"U"));
                }
                else
                {
                    if(!transactionExists.isEmpty())
                        transactionExists.get(transnumber).setLastAccess(i);
                }
                addToDirtyPageTable(s, i);
                updateHashofDirty(resource,i,transnumber);
                break;
            case 4:
                /*       if(!transactionExists.isEmpty() )
                transactionExists.get(transnumber).setState("A");
                else
                transactionExists.put(transnumber, new ttlRowObj("T"+transnumber,i,"A"));
                
                unComittedTrans.add(transnumber);
                abortedTrans.add(transnumber);
                //removeFromDirtyPageTable(transnumber);
                */
                break;
                
            default:
                break;
        }
    }
    
    void removeFromDirtyPageTable()
    {
        
        for(Map.Entry<String, DirtyPageQueue> entry : ResourceOnDirtyTable.entrySet())
        {
            while(abortedTrans.contains(ResourceOnDirtyTable.get(resource).getTransNumber()))
                ResourceOnDirtyTable.get(resource).removeFromTop();
            
        }
        ///    dpModel.setValueAt( ResourceOnDirtyTable.get(resource).getLastAccess(), index, 1);
        
    }
    
    int returnRowIndex(String res)
    {
        for(int i=0;i<dpModel.getRowCount();i++)
        {
            if(res.equals((String)dpModel.getValueAt(i, 0)))
            {
                return i;
            }
        }
        
        return -1;
    }
    
    void updateHashofDirty(String resource,int i,int trans)
    {
        DirtyPageQueue obj;
        if( ResourceOnDirtyTable.get(resource)==null)
        {
            ResourceOnDirtyTable.put(resource, new DirtyPageQueue(i,"T"+ String.valueOf(trans)));
        }
        else
        {
            obj= ResourceOnDirtyTable.get(resource);
            if(!obj.transactionExists("T"+trans))
                obj.AddData(i, "T"+trans);
        }
    }
    void removeFromTempValues()
    {
        for(Map.Entry<String, writeOperationClass> entry : tempValues.entrySet())
        {
            if(abortedTrans.contains(entry.getValue().getTransactionNumber()))
            {
                if( entry.getValue().removeTopData())
                {
                    while(abortedTrans.contains(entry.getValue().getTransactionNumber()))
                        entry.getValue().removeTopData();
                }
            }
        }
    }
    void insertValueInHashMap(int transnumber,int val,String resource)
    {
        writeOperationClass temp=tempValues.get(resource);
        temp.notInTableNow();
        temp.setTrans(transnumber);
        temp.setValues(val);
        temp.TruthStack(false);
    }
    
    void addToDirtyPageTable(String s, int i)
    {
        resource=returnResource(s);
        if(dirtyPageHash.get(resource.toUpperCase())==null)
        {
            dirtyPageHash.put(resource.toUpperCase(), i);
        }
    }
    
    void addDataToTable(HashMap<Integer, ttlRowObj> map)
    {
        clearTable(transTableModel);
        for (ttlRowObj value :map.values()) {
            transTableModel.addRow(new Object [] {value.getName(),value.getLastAccess(),value.getState()});
        }
        transactionExists.clear();
    }
    
    void addDataToDirtyTable(HashMap<String, Integer> map)
    {
        clearTable(dpModel);
        
        
        for (Map.Entry<String, Integer> entry : map.entrySet())
        {
            dpModel.addRow(new Object [] {entry.getKey(),entry.getValue()});
        }
        dirtyPageHash.clear();
    }
    
    
    void addDataToTable(HashMap<Integer, ttlRowObj> map,int i)
    {
        clearTable(transTableModel);
        for (ttlRowObj value :map.values()) {
            transTableModel.addRow(new Object [] {value.getName(),value.getLastAccess(),value.getState()});
        }
    }
    
    void addDataToDirtyTable(HashMap<String, Integer> map,int i)
    {
        clearTable(dpModel);
        
        for (Map.Entry<String, Integer> entry : map.entrySet())
        {
            dpModel.addRow(new Object [] {entry.getKey(),entry.getValue()});
        }
    }
    
    void clearTable(DefaultTableModel mod )
    {
        if(mod.getRowCount()>0)
            mod.setRowCount(0);
    }
    String returnResource(String s)
    {
        return s.substring(s.indexOf("(") + 1, s.indexOf(")")).toUpperCase();
    }
    
    int returnNewValue(String s)
    {
        return Integer.parseInt(s.substring(s.indexOf(")") + 1, s.length()));
    }
    
    int getTransactionNumber(String s)
    {
        return Character.getNumericValue(s.charAt(1));
    }
    int returnOperation(String s)
    {
        if(s.charAt(0)=='c'||s.charAt(0)=='C')
            return 1;
        if(s.charAt(0)=='r'||s.charAt(0)=='R')
            return 2;
        if(s.charAt(0)=='w'||s.charAt(0)=='W')
            return 3;
        if(s.charAt(0)=='a'||s.charAt(0)=='A')
            return 4;
        return 0;
    }
    
    public static HashMap<Integer,ttlRowObj> getTransactionHashmap()
    {
        return transactionExists;
    }
    
    public static HashMap<String,Integer> getDirtyPageHashmap()
    {
        return dirtyPageHash;
    }
    
    public static HashMap getTempValuesHashmap()
    {
        return tempValues;
    }
    public static  HashMap getInnitialValuesHashmap()
    {
        return innitialValues;
    }
    
}