/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1;

import java.io.Serializable;

/**
 *
 * @author hannah
 */
public class myBean extends Object implements Serializable {

    public static final String ISTATUS = "Login";

    private String status;
    private String name;

    public myBean() {
        status = ISTATUS;
        name = new String();
    }

    public String getStatus() {return status;}
    public void setStatus(String value) {status = value;}

    public String getName() {return name;}
    public void setName(String value) {name = value;}

}