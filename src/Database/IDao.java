/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.util.ArrayList;

/**
 *
 * @author Secret
 */
public interface IDao <Type>{
    Type getItem(Type item);
    void insertItem(Type item);
    void deleteItem(Type item);
    Type updateItem(Type item);
    ArrayList<Type> getItems();
    
    
}
