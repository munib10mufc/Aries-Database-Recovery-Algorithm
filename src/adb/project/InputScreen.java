/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package adb.project;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Munib
 */
public  class InputScreen extends javax.swing.JFrame {
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        inputfield = new javax.swing.JTextArea();
        startButton = new javax.swing.JButton();
        crashButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        outputtable = new javax.swing.JTable();
        label = new javax.swing.JLabel();
        countlabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TransTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        DirtyPageTable = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        datafield = new javax.swing.JTextArea();
        AnalyseButton = new javax.swing.JButton();
        redoButton = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        resultBox = new javax.swing.JTextArea();
        UndoButton = new javax.swing.JButton();
        ResetButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inputfield.setColumns(20);
        inputfield.setRows(5);
        jScrollPane1.setViewportView(inputfield);

        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        crashButton.setText("Crash");
        crashButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crashButtonActionPerformed(evt);
            }
        });

        outputtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Row", "Operation"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(outputtable);

        label.setText("Evaluated Row number: ");

        TransTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Transaction Id", "Last Access", "State"
            }
        ));
        jScrollPane3.setViewportView(TransTable);

        DirtyPageTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Page Id", "First Access"
            }
        ));
        jScrollPane4.setViewportView(DirtyPageTable);

        datafield.setColumns(20);
        datafield.setRows(5);
        jScrollPane5.setViewportView(datafield);

        AnalyseButton.setText("Analysis");
        AnalyseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnalyseButtonActionPerformed(evt);
            }
        });

        redoButton.setText("Redo");
        redoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redoButtonActionPerformed(evt);
            }
        });

        resultBox.setColumns(20);
        resultBox.setRows(5);
        jScrollPane6.setViewportView(resultBox);

        UndoButton.setText("Undo");
        UndoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UndoButtonActionPerformed(evt);
            }
        });

        ResetButton.setText("Reset");
        ResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(startButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(crashButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AnalyseButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(redoButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(UndoButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ResetButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(label)
                                .addGap(2, 2, 2)
                                .addComponent(countlabel))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane6))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(countlabel)
                            .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane6)
                                .addGap(6, 6, 6)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startButton)
                    .addComponent(crashButton)
                    .addComponent(AnalyseButton)
                    .addComponent(redoButton)
                    .addComponent(UndoButton)
                    .addComponent(ResetButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Creates new form InputScreen
     */
    int LastCheckPointIndex;
    Readthread th;
    String resource;
    static HashMap<Integer,ttlRowObj> transactionmap2;
    HashMap<Integer,ttlRowObj> transactionExistsMap;
    HashMap<String,Integer> dirtyPageHash;
    HashMap<String,Integer> innitialValues;
    HashMap <String,writeOperationClass> tempValues;
    HashMap <String,Integer> resultvalues;
    FileWriter fileWritter;
    BufferedWriter buffw;
    ArrayList<Integer> comittedtransactions;
    ArrayList<Integer> unComittedtransactions;
    HashMap <String,DirtyPageQueue> ResourceDirtyTable;
    Scanner classScanner;
    boolean fileupload=false;
    public InputScreen() throws IOException {
        initComponents();
        //inputfield.setText("r1(A), r2(A), w1(A)10, w2(A)9, r2(B), w2(B)7,w1(B)9, r2(A), w1(A)1, c1,w2(A)2, r2(B), w2(B)7,c2,w3(CA)9,w3(   c)2 ,w3( C )18,c3");
        //datafield.setText("A(2),B(10),CA(12),C(8)");
        transactionmap2= new HashMap<>();
        programStartButtonsConfig();
        
        fileupload=false;
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
    
    public InputScreen(Scanner scan)
    {
        fileupload=true;
        classScanner=scan;
        initComponents();
        String pp= classScanner.nextLine();
        String[] values=pp.split("\\*",-1);
        if(values.length==2)
        {
        inputfield.setText(values[0]);
        datafield.setText(values[1]);
        transactionmap2= new HashMap<>();
        programStartButtonsConfig();
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        }
        else
        {
          JOptionPane.showMessageDialog(this, "Error in template of input values","Values error",JOptionPane.ERROR_MESSAGE);
           FileUpload obj = new FileUpload();
           obj.setVisible(true);
           this.setVisible(false);
        }
            
    }
    
    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        
        afterStartButtonConfig();
        String values=datafield.getText();
        String data= inputfield.getText();
        if(!values.equals("") && !data.equals(""))
        {
            data=data.replaceAll("\\s","");
            values=values.replaceAll("\\s","");
            innitialValues= (HashMap<String,Integer>) getDataValues(values);
            if(!innitialValues.isEmpty())
            {
                th= new Readthread(outputtable,data,countlabel,TransTable,DirtyPageTable,innitialValues,resultBox,classScanner,fileupload);
                th.start();
            }
            else
                
                resetButtonActionPerformed();
        }
        else
        {
            if(data.equals(""))
            {
                JOptionPane.showMessageDialog(this, "Please add Transactions in first box","Transaction Input error",JOptionPane.ERROR_MESSAGE);
            }
            if(values.equals(""))
            {
                JOptionPane.showMessageDialog(this, "Resources' Values not set","Default Values error",JOptionPane.ERROR_MESSAGE);
            }
            programStartButtonsConfig();
        }
    }//GEN-LAST:event_startButtonActionPerformed
    
    public static HashMap<String,Integer> getDataValues(String data)
    {
        HashMap<String,Integer> innitial= new HashMap<String,Integer>();
        try {
            String [] eachRow=data.split(",",-1);
            for(String s: eachRow)
            {
                String re=s.substring(0, s.indexOf("(")).toUpperCase();
                String v=s.substring(s.indexOf("(") + 1, s.indexOf(")"));
                innitial.put(re,Integer.parseInt(v));
            }
            
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Input Format of resources' default value is incorrect","Default Values error",JOptionPane.ERROR_MESSAGE);
            innitial.clear();
        }
        return innitial;
    }
    
    int returnNewValue(String s)
    {
        return Integer.parseInt(s.substring(s.indexOf(")") + 1, s.length()));
    }
    public JTable getTable()
    {
        return outputtable;
    }
    private void crashButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crashButtonActionPerformed
        afterCrashButtonConfig();
        th.kill();
        comittedtransactions= Readthread.ComittedTrans;
        unComittedtransactions=Readthread.unComittedTrans;
        ResourceDirtyTable=Readthread.ResourceOnDirtyTable;
    }//GEN-LAST:event_crashButtonActionPerformed
    
    
    
    private void AnalyseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnalyseButtonActionPerformed
        // TODO add your handling code here:
        afterAnalysisButtonConfig();
        
        
        
        LastCheckPointIndex = returnCheckpointIndex(outputtable);
        LastCheckPointIndex++;
        transactionExistsMap= Readthread.getTransactionHashmap();
        dirtyPageHash= Readthread.getDirtyPageHashmap();
        innitialValues=Readthread.getInnitialValuesHashmap();
        tempValues= Readthread.getTempValuesHashmap();
       // resultvalues= Readthread.getFinalResultsHashMap();
        File file =new File("OperationsSequence.txt");
        try {
            file.createNewFile();
            
            fileWritter = new FileWriter(file.getName());
            buffw = new BufferedWriter(fileWritter);
            buffw.write("********************************************");
            buffw.newLine();
            buffw.write("***************Analysis Phase***************");
            buffw.newLine();
            buffw.write("********************************************");
            buffw.newLine();
            buffw.write("Analysis Started from line number: "+LastCheckPointIndex);
            buffw.newLine();
        } catch (IOException ex) {
             JOptionPane.showMessageDialog(this, "Error occured: "+ex.getMessage(),"Error occured",JOptionPane.ERROR_MESSAGE);
           
        }
        for(int i=LastCheckPointIndex;i<outputtable.getRowCount();i++)
        {
            try {
                addToTransactionTable((String)outputtable.getValueAt(i, 1), i+1);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error occured: "+ex.getMessage(),"Error occured",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_AnalyseButtonActionPerformed

    private void redoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoButtonActionPerformed
        
        afterRedoButtonConfig();
        
        int leastindex= returnLeastIndex();
        try {
            buffw.newLine();
            buffw.newLine();
            buffw.write("********************************************");
            buffw.newLine();
            buffw.write("*****************Redo Phase*****************");
            buffw.newLine();
            buffw.write("********************************************");
            buffw.newLine();
            buffw.write("Redo Started from index: "+leastindex);
            buffw.newLine();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error occured: "+ex.getMessage(),"Error occured",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(InputScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i=leastindex;i<outputtable.getRowCount();i++)
        {
            try {
                redoPhase((String)outputtable.getValueAt(i, 1));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error occured: "+ex.getMessage(),"Error occured",JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(InputScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_redoButtonActionPerformed

    private void UndoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UndoButtonActionPerformed
        // TODO add your handling code here:
        afterUndoButtonConfig();
        ArrayList<Integer> uncommittedTrans=returnUncomittedTrans();
        try {
            buffw.newLine();
            buffw.newLine();
            buffw.write("********************************************");
            buffw.newLine();
            buffw.write("*****************Undo Phase*****************");
            buffw.newLine();
            buffw.write("********************************************");
            buffw.newLine();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error occured: "+ex.getMessage(),"Error occured",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(InputScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(Map.Entry<String, writeOperationClass> entry : tempValues.entrySet())
        {
            //if(uncommittedTrans.contains(entry.getValue().getTransactionNumber()))
            if(!comittedtransactions.contains(entry.getValue().getTransactionNumber()))
            {
                try {
                    buffw.write("Reverted Effect of transaction T"+entry.getValue().getTransactionNumber()+" from resource:"+entry.getKey()+" Value changed from: "+entry.getValue().getValue()+" to: "+entry.getValue().nextVal());
                    buffw.newLine();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error occured: "+ex.getMessage(),"Error occured",JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(InputScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
                if( entry.getValue().removeTopData())
                {
                    
                    //while(uncommittedTrans.contains(entry.getValue().getTransactionNumber()))
                    while(!comittedtransactions.contains(entry.getValue().getTransactionNumber()))
                    {
                        try {
                            buffw.write("Reverted Effect of transaction T"+entry.getValue().getTransactionNumber()+" from resource:"+entry.getKey()+" Value changed from :"+entry.getValue().getValue()+" to "+entry.getValue().nextVal());
                            buffw.newLine();
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(this, "Error occured: "+ex.getMessage(),"Error occured",JOptionPane.ERROR_MESSAGE);
                            Logger.getLogger(InputScreen.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        entry.getValue().removeTopData();
                        
                    }
                }
            }
        }
        try {
            addDataToResultBox();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error occured: "+ex.getMessage(),"Error occured",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(InputScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            buffw.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error occured: "+ex.getMessage(),"Error occured",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(InputScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
         JOptionPane.showMessageDialog(this, "All operations of recovery have been stored to log file named OperationSequence.Txt ","Operations File Saved",JOptionPane.PLAIN_MESSAGE);

    }//GEN-LAST:event_UndoButtonActionPerformed

    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonActionPerformed
        // TODO add your handling code here:
        resetButtonActionPerformed();
        
    }//GEN-LAST:event_ResetButtonActionPerformed
    
    private int returnCheckpointIndex(JTable trans)
    {
        String obj;
        for(int i=trans.getRowCount()-1;i>=0;i--)
        {
            obj=  (String) trans.getValueAt(i, 1);
            if(obj.contains("End_CheckPoint"))
                return i;
        }
        return -1;
    }
    
    void resetButtonActionPerformed()
    {
        programStartButtonsConfig();
        resultBox.setText("");
        DefaultTableModel temp=  (DefaultTableModel)TransTable.getModel();
        temp.setRowCount(0);
        temp=  (DefaultTableModel)DirtyPageTable.getModel();
        temp.setRowCount(0);
        temp=  (DefaultTableModel)outputtable.getModel();
        temp.setRowCount(0);
        countlabel.setText("");
        if(innitialValues!=null &&innitialValues.size()>0)
            innitialValues.clear();
       // if(Readthread.ResultMap!=null && Readthread.ResultMap.size()>0)
       //     Readthread.ResultMap.clear();
        
        if(Readthread.dirtyPageHash!=null && Readthread.dirtyPageHash.size()>0)
            Readthread.dirtyPageHash.clear();
        
        
        if(Readthread.tempValues!=null && Readthread.tempValues.size()>0)
            Readthread.tempValues.clear();
        
        
        if(Readthread.transactionExists!=null && Readthread.transactionExists.size()>0)
            Readthread.transactionExists.clear();
    }
    
    private ArrayList<Integer> returnUncomittedTrans()
    {
        ArrayList<Integer> uncomm=new ArrayList<>();
        
        DefaultTableModel temp= (DefaultTableModel)TransTable.getModel();
        for(int i=0;i<temp.getRowCount();i++)
        {
            if("U".equals((String) temp.getValueAt(i, 2)))
                uncomm.add(getTransactionNumber((String)temp.getValueAt(i, 0)));
        }
        return uncomm;
    }
    private int returnLeastIndex()
    {
        
        DefaultTableModel temp= (DefaultTableModel)DirtyPageTable.getModel();
        if(DirtyPageTable.getRowCount()==0)
            return 0;
        else if(DirtyPageTable.getRowCount()==1)
            return (int) temp.getValueAt(0, 1);
        else
        {
            int index=(int) temp.getValueAt(0, 1);
            for(int i=0;i<DirtyPageTable.getRowCount();i++)
            {
                if(index>(int) temp.getValueAt(i, 1))
                    index=(int) temp.getValueAt(i, 1);
            }
            return index;
        }
    }
    
    
    
    private void redoPhase(String s) throws IOException
    {
        int op=returnOperation(s);
        int transnumber=getTransactionNumber(s);
        
        switch (op)
        {
            case 1:
                for (Map.Entry<String, writeOperationClass> entry : tempValues.entrySet())
                {
                    if(entry.getValue().getTransactionNumber()==transnumber)
                    {
                       // resultvalues.put(entry.getKey(), entry.getValue().getValue()); intentionally commented...
                    }
                }
                break;
            case 2:
                break;
            case 3:
                resource=returnResource(s);
                int val= returnNewValue(s);
                if(!tempValues.containsKey(resource))
                {
                    tempValues.put(resource, new writeOperationClass(transnumber, val,resource));
                }
                addDataToResultBox();
                break;
            case 4:
                break;
            default:
                break;
        }
    }
    
    void insertValueInHashMap(int transnumber,int val,String resource)
    {
        writeOperationClass temp=tempValues.get(resource);
        temp.setTrans(transnumber);
        temp.setValues(val);
    }
    
    private void addDataToResultBox() throws IOException
    {
        String s= new String();
        for (Map.Entry<String, writeOperationClass> entry : tempValues.entrySet())
        {
            if(!entry.getValue().isInTable())
            {
                String temp=entry.getValue().ReturnPrevValues();
                String [] diffoperations = temp.split(",",-1);
                for(int i=0;i< diffoperations.length;i++)
                {
                    buffw.write(diffoperations[i]);
                    buffw.newLine();
                }
                //buffw.write("Added Resource: "+entry.getKey()+" with value: "+entry.getValue().getValue()+" by transaction T: "+(entry.getValue().getTransactionNumber()!=0?entry.getValue().getTransactionNumber():" (Default)"));
                
            }
            if(s.isEmpty())
                s=entry.getKey()+"("+entry.getValue().getValue()+")=>T"+(entry.getValue().getTransactionNumber()!=0?entry.getValue().getTransactionNumber():" (Default)");
            else
                s=s+"\n"+entry.getKey()+"("+entry.getValue().getValue()+")=>T"+(entry.getValue().getTransactionNumber()!=0?entry.getValue().getTransactionNumber():" (Default)");
        }
        resultBox.setText(s);
    }
    
    String returnResource(String s)
    {
        return s.substring(s.indexOf("(") + 1, s.indexOf(")")).toUpperCase();
    }
    
    void addToTransactionTable(String s,int i) throws IOException
    {
        int op=returnOperation(s);
        
        int transnumber=getTransactionNumber(s);
        
        switch (op)
        {
            case 1:
                updateCommitStatusinTransTable(s);
                
                comittedtransactions.add(transnumber);
                break;
            case 2:
                
                break;
            case 3:
                /*if value is W(updated) then add to transaction table*/
                
                DefaultTableModel transmodel= (DefaultTableModel) TransTable.getModel();
                int rowindex=existsinTable(transnumber);
                if(rowindex>=0)
                {
                    transmodel.setValueAt(i, rowindex, 1);
                    buffw.write("Updated last access of Transaction T"+transnumber+" to: "+i);
                    buffw.newLine();
                    
                }
                else
                {
                    transmodel.addRow(new Object[]{"T"+transnumber,i,"U"});
                    buffw.write("Added Transaaction T"+transnumber+" with last access on: "+i);
                    buffw.newLine();
                }
                addToDirtyPageTable(s, i);
                break;
            case 4:
           /*      DefaultTableModel transmodel2= (DefaultTableModel) TransTable.getModel();
                int rowindex2=existsinTable(transnumber);
                if(rowindex2>=0)
                {
                    transmodel2.setValueAt("A", rowindex2, 2);
                   // buffw.write("Updated last access of Transaction T"+transnumber+" to: "+i);
                   /// buffw.newLine();
                    
                }
                else
                {
                    transmodel2.addRow(new Object[]{"T"+transnumber,i,"A"});
                   // buffw.write("Added Transaaction T"+transnumber+" with last access on: "+i);
                   // buffw.newLine();
                }
                unComittedtransactions.add(transnumber);
                removeFromTempValues(transnumber);
                removeFromDirtyPageTable(resource,transnumber);
            */
                default:
                break;
        }
    }
    
    void removeFromDirtyPageTable(String resource,int transnumber)
    {
         DirtyPageQueue te;
    int index=returnRowIndex(resource);
    if(index>-1)
    {
        if(ResourceDirtyTable.get(resource)!=null)
        {
            te=ResourceDirtyTable.get(resource);
           // te.removeFromTop();
           String temp="T"+transnumber;
            while(temp.equals(te.getTransNumber()))
                te.removeFromTop();
           
        }
    }
    }
     int returnRowIndex(String res)
    {
     
        DefaultTableModel dpModel= (DefaultTableModel) DirtyPageTable.getModel();
    for(int i=0;i>dpModel.getRowCount();i++)
    {
    if(res.equals((String)dpModel.getValueAt(i, 0)))
    {
    return i;
    }
    }
    
        return -1;
    }
    
    void removeFromTempValues(int trans)
    {
        for(Map.Entry<String, writeOperationClass> entry : tempValues.entrySet())
        {
            if(trans==entry.getValue().getTransactionNumber())
            {
                if( entry.getValue().removeTopData())
                {
                    while(trans==entry.getValue().getTransactionNumber())
                        entry.getValue().removeTopData();
                }
            }
        }
    }
    int existsinTable(int transnumber)
    {
        DefaultTableModel transmodel=(DefaultTableModel) TransTable.getModel();
        String tr="T"+transnumber;
        for(int i=0;i<TransTable.getRowCount();i++)
        {
            if(tr.equals((String)transmodel.getValueAt(i, 0)))
            {
                return i;
            }
        }
        return -1;
    }
    void updateResourceinTransactionTable(String s,int i)
    {
        DefaultTableModel transmodel=(DefaultTableModel) TransTable.getModel();
        for(int p=0;p<TransTable.getRowCount();p++)
        {
            if(s.equalsIgnoreCase((String)transmodel.getValueAt(p, 1)));
            {
                transmodel.setValueAt(i, p, 2);
            }
        }
    }
    void updateCommitStatusinTransTable(String s) throws IOException
    {
        DefaultTableModel transmodel=(DefaultTableModel) TransTable.getModel();
        int transnumber=getTransactionNumber(s);
        for(int p=0;p<TransTable.getRowCount();p++)
        {
            if(transnumber==getTransactionNumber((String)transmodel.getValueAt(p, 0)))
            {
                transmodel.setValueAt("C", p, 2);
                buffw.write("Updated status of Transaction T"+transnumber+" to: 'C'");
                buffw.newLine();
                break;
            }
            //else add new row here
        }
    }
    void addToDirtyPageTable(String s, int i)
    {
        resource=returnResource(s);
        DefaultTableModel dpmodel= (DefaultTableModel) DirtyPageTable.getModel();
        int result=existsInDirtyPage(resource);
        if(result==-1)
        {
            dpmodel.addRow(new Object [] {resource,i});
        }
    }
    
    int existsInDirtyPage(String s)
    {
        DefaultTableModel transmodel=(DefaultTableModel) DirtyPageTable.getModel();
        
        for(int i=0;i<DirtyPageTable.getRowCount();i++)
        {
            if(s.equals((String)transmodel.getValueAt(i, 0)))
            {
                return i;
            }
        }
        return -1;
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
    
    void programStartButtonsConfig()
    {
        startButton.setEnabled(true);
        crashButton.setEnabled(false);
        AnalyseButton.setEnabled(false);
        redoButton.setEnabled(false);
        UndoButton.setEnabled(false);
    }
    
    void afterStartButtonConfig()
    {
        startButton.setEnabled(false);
        crashButton.setEnabled(true);
        AnalyseButton.setEnabled(false);
        redoButton.setEnabled(false);
        UndoButton.setEnabled(false);
    }
    
    void afterCrashButtonConfig()
    {
        startButton.setEnabled(false);
        crashButton.setEnabled(false);
        AnalyseButton.setEnabled(true);
        redoButton.setEnabled(false);
        UndoButton.setEnabled(false);
    }
    
    void afterAnalysisButtonConfig()
    {
        startButton.setEnabled(false);
        crashButton.setEnabled(false);
        AnalyseButton.setEnabled(false);
        redoButton.setEnabled(true);
        UndoButton.setEnabled(false);
    }
    
    void afterRedoButtonConfig()
    {
        startButton.setEnabled(false);
        crashButton.setEnabled(false);
        AnalyseButton.setEnabled(false);
        redoButton.setEnabled(false);
        UndoButton.setEnabled(true);
    }
    
    void afterUndoButtonConfig()
    {
        startButton.setEnabled(false);
        crashButton.setEnabled(false);
        AnalyseButton.setEnabled(false);
        redoButton.setEnabled(false);
        UndoButton.setEnabled(false);
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
        * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
        */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            
            java.util.logging.Logger.getLogger(InputScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InputScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InputScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InputScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new InputScreen().setVisible(true);
            } catch (IOException ex) {
               Logger.getLogger(InputScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AnalyseButton;
    private javax.swing.JTable DirtyPageTable;
    private javax.swing.JButton ResetButton;
    private javax.swing.JTable TransTable;
    private javax.swing.JButton UndoButton;
    private javax.swing.JLabel countlabel;
    private javax.swing.JButton crashButton;
    public static javax.swing.JTextArea datafield;
    public static javax.swing.JTextArea inputfield;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel label;
    private javax.swing.JTable outputtable;
    private javax.swing.JButton redoButton;
    private javax.swing.JTextArea resultBox;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
}
