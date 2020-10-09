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
class ttlRowObj
{
    int lastaccess;
    String name,state;
    
    public ttlRowObj(String Name,int LastAccess,String State) {
        this.lastaccess = LastAccess;
        this.name=Name;
        this.state=State;
    }
    int getLastAccess()
    {
        return this.lastaccess;
    }
    String getName()
    {
        return this.name;
    }
    String getState()
    {
        return this.state;
    }
    void setState(String p)
    {
        this.state=p;
    }
    void setLastAccess(int p)
    {
        this.lastaccess=p;
    }
}