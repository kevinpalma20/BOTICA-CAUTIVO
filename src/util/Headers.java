/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util; 

/**
 *
 * @author kpalmall
 */
public class Headers { 
    public static final String headres_category[] = new String[] {"ID", "NOMBRE"
            , "ESTADO"};
    
    public static final String headres_product[] = 
            new String[] {"ID", "NOMBRE", "MARCA", "PRECIO", "STOCK", "CATEGORIA"
                    , "ESTADO"};
    
    public static final String headres_cart[] = 
            new String[] {"ID", "PRODUCTO", "PRECIO", "CANTIDAD", "IMPORTE"};
    
    public static final String headres_customer[] = 
            new String[] {"ID", "CLIENTE", "DNI", "EMAIL", "PHONE"};
    
    public static final String headres_sale[] = 
            new String[] {"ID", "USUARIO", "CLIENTE", "FECHA", "HORA", "DESCUENTO"
                    , "SUBTOTAL", "TOTAL"};
}
